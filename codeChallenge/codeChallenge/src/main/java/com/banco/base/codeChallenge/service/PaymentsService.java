package com.banco.base.codeChallenge.service;

import java.util.concurrent.ExecutionException;

import com.banco.base.codeChallenge.dto.PaymentDTO;

public interface PaymentsService {

	PaymentDTO savePayment(PaymentDTO paymentDTO);

	PaymentDTO getPayment(Long paymentId);

	PaymentDTO updatePayment(Long paymentId, PaymentDTO paymentDTO) throws InterruptedException, ExecutionException ;

}
