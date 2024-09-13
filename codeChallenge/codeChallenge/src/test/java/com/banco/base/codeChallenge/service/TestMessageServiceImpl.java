package com.banco.base.codeChallenge.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class TestMessageServiceImpl extends BaseServiceTest {

	@Test
	void getMessage() {
		when(messageSource.getMessage(isA(String.class), any(), any())).thenReturn("Data not found using provided search criteria");
		String response = messageServiceInj.getMessage("api.generic.messages.1000");
		assertNotNull(response);
	}

}
