package com.banco.base.codeChallenge.service.impl;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.banco.base.codeChallenge.dto.PaymentDTO;
import com.banco.base.codeChallenge.service.KafkaProducerService;

@Component
public class KafkaProducerServiceImpl implements KafkaProducerService{

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);
	
	@Qualifier
	private final KafkaTemplate<String, PaymentDTO> kafkaTemplate;

	public KafkaProducerServiceImpl(KafkaTemplate<String, PaymentDTO> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public boolean sendMessage(PaymentDTO paymentDTO, String topicName) throws InterruptedException, ExecutionException {
		SendResult<String, PaymentDTO> sendResult = kafkaTemplate.send(topicName, paymentDTO).get();
		LOGGER.info("Message {} has been sucessfully sent to the topic: {}", paymentDTO.toString(), topicName);
		LOGGER.info(sendResult.toString());
		return true;
	}
}
