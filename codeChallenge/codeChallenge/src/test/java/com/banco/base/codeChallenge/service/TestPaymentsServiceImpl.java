package com.banco.base.codeChallenge.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.banco.base.codeChallenge.dao.PaymentEntity;
import com.banco.base.codeChallenge.dto.PaymentDTO;
import com.banco.base.codeChallenge.exceptions.ServiceException;

@ActiveProfiles("test")
public class TestPaymentsServiceImpl extends BaseServiceTest {

	@Test
	void savePayment() {
		when(paymentsRepository.save(isA(PaymentEntity.class))).thenReturn(paymentEntity);
		PaymentDTO response = paymentsService.savePayment(paymentDTO);
		assertNotNull(response);
	}
	
	@Test
	void getPayment() {
		when(paymentsRepository.findById(isA(Long.class))).thenReturn(Optional.of(paymentEntity));
		PaymentDTO response = paymentsService.getPayment(2L);
		assertNotNull(response);
	}
	
	@Test
	void updatePayment() throws InterruptedException, ExecutionException {
		when(paymentsRepository.save(isA(PaymentEntity.class))).thenReturn(paymentEntity);
		when(paymentsRepository.findById(isA(Long.class))).thenReturn(Optional.of(paymentEntity));
		when(kakKafkaProducerService.sendMessage(isA(PaymentDTO.class))).thenReturn(Boolean.TRUE);
		PaymentDTO response = paymentsService.updatePayment(2L, paymentDTO);
		assertNotNull(response);
	}

	@Test
	void savePaymentTestExcep() {
		when(messageService.getMessage(isA(String.class))).thenReturn("message error");
		ServiceException thrown = assertThrows(ServiceException.class,
				() -> paymentsService.savePayment(paymentDTO), "error");
		assertTrue(thrown.getMessage().contains("error"));
	}
	
	@Test
	void getPaymentTestExcep() {
		when(messageService.getMessage(isA(String.class))).thenReturn("message error");
		ServiceException thrown = assertThrows(ServiceException.class,
				() -> paymentsService.getPayment(2L));
		assertTrue(thrown.getMessage().contains("error"));
	}
	
	@Test
	void updatePaymentTestExcep() {
		when(messageService.getMessage(isA(String.class))).thenReturn("message error");
		ServiceException thrown = assertThrows(ServiceException.class,
				() -> paymentsService.updatePayment(2L, paymentDTO));
		assertTrue(thrown.getMessage().contains("error"));
	}

}
