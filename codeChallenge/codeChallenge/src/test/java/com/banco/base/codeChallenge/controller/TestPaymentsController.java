package com.banco.base.codeChallenge.controller;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.banco.base.codeChallenge.JsonUtil;
import com.banco.base.codeChallenge.dto.PaymentDTO;

public class TestPaymentsController extends BaseControllerTest {

	@Test
	void getPayment() throws Exception {
		when(paymentsServiceImpl.getPayment(isA(Long.class))).thenReturn(paymentDTO);
		mvc.perform(MockMvcRequestBuilders.get("/payments/" + 2).accept(contentType)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.responseBody").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseBody.paymentId").value(paymentDTO.getPaymentId()));
	}

	@Test
	void savePayment() throws Exception {
		when(paymentsServiceImpl.savePayment(isA(PaymentDTO.class))).thenReturn(paymentDTO);
		mvc.perform(MockMvcRequestBuilders.post("/payments/").content(JsonUtil.asJsonString(paymentDTO))
				.contentType(contentType).accept(contentType)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseBody").exists()).andExpect(MockMvcResultMatchers
						.jsonPath("$.responseBody.description").value(paymentDTO.getDescription()));
	}

	@Test
	void updatePayment() throws Exception {
		when(paymentsServiceImpl.updatePayment(isA(Long.class), isA(PaymentDTO.class))).thenReturn(paymentDTO);
		mvc.perform(MockMvcRequestBuilders.put("/payments/" + 2).content(JsonUtil.asJsonString(paymentDTO2))
				.contentType(contentType).accept(contentType)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseBody").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseBody.status").value(paymentDTO.getStatus()));
	}

}
