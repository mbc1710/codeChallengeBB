package com.banco.base.codeChallenge.service;

import java.util.concurrent.ExecutionException;

import com.banco.base.codeChallenge.dto.PaymentDTO;

public interface KafkaProducerService {

	boolean sendMessage(PaymentDTO paymentDTO, String topicName) throws InterruptedException, ExecutionException;
}
