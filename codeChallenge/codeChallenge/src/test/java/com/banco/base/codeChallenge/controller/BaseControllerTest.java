package com.banco.base.codeChallenge.controller;

import java.nio.charset.Charset;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.banco.base.codeChallenge.BaseTest;
import com.banco.base.codeChallenge.service.MessageService;
import com.banco.base.codeChallenge.service.impl.PaymentsServiceImpl;

@ActiveProfiles("test")
@WebMvcTest(controllers = PaymentsController.class)
public abstract class BaseControllerTest extends BaseTest {

	@Autowired
	private WebApplicationContext context;
	protected final static Locale LOCALE = new Locale("es", "MX");
	protected MediaType contentType;
	protected HttpHeaders httpHeaders = new HttpHeaders();

	@Autowired
	protected MockMvc mvc;

	@MockBean
	protected PaymentsServiceImpl paymentsServiceImpl;

	@MockBean
	protected MessageService messageService;

	public BaseControllerTest() {
		this.setUpContentType();
	}

	@BeforeEach
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	protected void setUpContentType() {
		this.contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(),
				Charset.forName("utf8"));
	}

}
