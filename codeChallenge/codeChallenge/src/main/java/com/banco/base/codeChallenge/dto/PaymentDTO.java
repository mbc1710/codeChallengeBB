package com.banco.base.codeChallenge.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentDTO implements Serializable{

    private static final long serialVersionUID = 1L;

	private Long paymentId;
	private String description;
	private Integer numberProducts;
	private String accountHolder;
	private String paymentReceiver;
	private String status;
	private Double amount;
}
