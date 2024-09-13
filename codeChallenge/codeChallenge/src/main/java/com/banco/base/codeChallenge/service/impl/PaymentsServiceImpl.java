package com.banco.base.codeChallenge.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.base.codeChallenge.converter.PaymentsConverter;
import com.banco.base.codeChallenge.dao.PaymentEntity;
import com.banco.base.codeChallenge.dto.PaymentDTO;
import com.banco.base.codeChallenge.enums.StatusEnum;
import com.banco.base.codeChallenge.exceptions.ServiceException;
import com.banco.base.codeChallenge.repository.PaymentsRepository;
import com.banco.base.codeChallenge.service.KafkaProducerService;
import com.banco.base.codeChallenge.service.MessageService;
import com.banco.base.codeChallenge.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentsServiceImpl.class);

	@Value("${kafka.payment.notification.topic}")
	private String topicName;

	@Value("${kafka.payment.notification.topic.error}")
	private String topicNameError;

	@Autowired
	private MessageService messageService;

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@Autowired
	private PaymentsRepository paymentsRepository;

	@Override
	public PaymentDTO savePayment(PaymentDTO paymentDTO) {
		PaymentDTO response;
		try {
			response = PaymentsConverter.convertToPaymentDTOFromPayment(
					paymentsRepository.save(PaymentsConverter.convertToPaymentFromPaymentDTO(paymentDTO)));
		} catch (Exception ex) {
			LOGGER.error(messageService.getMessage("api.generic.messages.1001") + ex.getCause(), ex);
			throw new ServiceException(messageService.getMessage("api.generic.messages.1001") + ex);
		}
		return response;
	}

	@Override
	public PaymentDTO getPayment(Long paymentId) {
		PaymentDTO response;
		try {
			response = PaymentsConverter.convertToPaymentDTOFromPayment(paymentsRepository.findById(paymentId).get());
		} catch (Exception ex) {
			LOGGER.error(messageService.getMessage("api.generic.messages.1000") + ex.getCause(), ex);
			throw new ServiceException(messageService.getMessage("api.generic.messages.1000") + ex);
		}
		return response;
	}

	@Override
	@Transactional
	public PaymentDTO updatePayment(Long paymentId, PaymentDTO paymentDTO)
			throws InterruptedException, ExecutionException {
		PaymentDTO response;
		try {
			Optional<PaymentEntity> paymentEntity = paymentsRepository.findById(paymentId);
			if (paymentEntity.isPresent()) {
				Optional<StatusEnum> status = StatusEnum.findByName(paymentDTO.getStatus());
				if (status.isPresent()) {
					paymentEntity.get().setStatus(status.get().getName());
					paymentEntity.get().setUpdateDate(new Date());
					paymentEntity.get().setUser("User_updated_id");
					response = PaymentsConverter
							.convertToPaymentDTOFromPayment(paymentsRepository.save(paymentEntity.get()));
					kafkaProducerService.sendMessage(
							PaymentsConverter.convertToPaymentDTOFromPayment(paymentEntity.get()), topicName);
				} else
					throw new IllegalArgumentException(messageService.getMessage("api.commons.exceptions.1000"));
			} else {
				throw new IllegalArgumentException(messageService.getMessage("api.generic.messages.1000"));
			}
		} catch (Exception ex) {
			paymentDTO.setStatus(StatusEnum.ERROR.getName());
			kafkaProducerService.sendMessage(paymentDTO, topicNameError);
			LOGGER.error(messageService.getMessage("api.generic.messages.1002") + ex.getCause(), ex);
			throw new ServiceException(messageService.getMessage("api.generic.messages.1002") + ex);
		}
		return response;
	}

}
