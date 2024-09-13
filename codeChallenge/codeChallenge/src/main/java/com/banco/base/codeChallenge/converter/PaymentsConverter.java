package com.banco.base.codeChallenge.converter;

import java.util.Date;

import com.banco.base.codeChallenge.dao.PaymentEntity;
import com.banco.base.codeChallenge.dto.PaymentDTO;

public class PaymentsConverter {

    public static PaymentDTO convertToPaymentDTOFromPayment(PaymentEntity payment) {
        return PaymentDTO.builder()
        		.paymentId(payment.getPaymentId())
        		.description(payment.getDescription())
        		.numberProducts(payment.getNumberProducts())
        		.accountHolder(payment.getAccountHolder())
        		.paymentReceiver(payment.getPaymentReceiver())
        		.status(payment.getStatus())
        		.amount(payment.getAmount())
                .build();
    }

    public static PaymentEntity convertToPaymentFromPaymentDTO (PaymentDTO paymentDTO) {
        return PaymentEntity.builder()
                .description(paymentDTO.getDescription())
                .amount(paymentDTO.getAmount())
                .accountHolder(paymentDTO.getAccountHolder())
                .paymentReceiver(paymentDTO.getPaymentReceiver())
                .numberProducts(paymentDTO.getNumberProducts())
                .status(paymentDTO.getStatus())
                .createDate(new Date())
                .user("user_create")
                .build();
    }
}
