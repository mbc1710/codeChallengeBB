package com.banco.base.codeChallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.ActiveProfiles;

import com.banco.base.codeChallenge.dto.PaymentDTO;

@ActiveProfiles("test")
public class TestKafkaProducerServiceImpl extends BaseServiceTest {

	@Test
	void savePayment() throws InterruptedException, ExecutionException {
//		future = new CompletableFuture<>();
//		future.complete(new SendResult<>(new ProducerRecord<>("myTopic", paymentDTO), new RecordMetadata(
//				new TopicPartition("myTopic", 1), 42, 23, 123456, 4, 8)));
//
//		when(kafkaTemplate.send(isA(String.class), isA(PaymentDTO.class))).thenReturn(future);
//		boolean response = kafkaProducerServiceImpl.sendMessage(paymentDTO);
//		assertEquals(response, Boolean.TRUE);
	}

}
