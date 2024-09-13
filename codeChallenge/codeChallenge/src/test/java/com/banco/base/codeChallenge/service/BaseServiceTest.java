package com.banco.base.codeChallenge.service;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import com.banco.base.codeChallenge.BaseTest;
import com.banco.base.codeChallenge.dto.PaymentDTO;
import com.banco.base.codeChallenge.repository.PaymentsRepository;
import com.banco.base.codeChallenge.service.impl.KafkaProducerServiceImpl;
import com.banco.base.codeChallenge.service.impl.MessageServiceImpl;
import com.banco.base.codeChallenge.service.impl.PaymentsServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public abstract class BaseServiceTest extends BaseTest {

	@Mock
	protected PaymentsRepository paymentsRepository;

	@Mock
	protected MessageService messageService;

	@Mock
	protected MessageSource messageSource;
	
	@Mock
	protected KafkaProducerService kakKafkaProducerService;
	
	@Mock
	protected KafkaTemplate<String, PaymentDTO> kafkaTemplate;
	
	@Mock
	protected CompletableFuture<SendResult<String, PaymentDTO>> future;

	@InjectMocks
	protected PaymentsServiceImpl paymentsService;

	@InjectMocks
	protected MessageServiceImpl messageServiceInj;
	
	@InjectMocks
	protected KafkaProducerServiceImpl kafkaProducerServiceImpl;

	@Value("${kafka.payment.notification.topic}")
	private String topicName;

	@BeforeEach
	public void setUp() {
		ReflectionTestUtils.setField(kafkaProducerServiceImpl, "topicName", "topicName");
	}
}
