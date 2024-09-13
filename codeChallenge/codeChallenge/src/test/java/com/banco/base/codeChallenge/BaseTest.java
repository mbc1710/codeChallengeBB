package com.banco.base.codeChallenge;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.banco.base.codeChallenge.dao.PaymentEntity;
import com.banco.base.codeChallenge.dto.PaymentDTO;

import ch.qos.logback.classic.BasicConfigurator;

public abstract class BaseTest {

	public BaseTest() {
		this.setup();
	}

	protected final static Logger LOGGER = LoggerFactory.getLogger(BasicConfigurator.class);

	protected Integer paymentId = 2;
	protected PaymentDTO paymentDTO = new PaymentDTO();
	protected PaymentDTO paymentDTO2 = new PaymentDTO();
	protected PaymentEntity paymentEntity = new PaymentEntity();

	private void setup() {
		this.setMemoryPaymentDTO();
		this.setMemoryPaymentEntity();
		this.setMemoryPaymentDTO2();
	}

	private void setMemoryPaymentDTO2() {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setPaymentId(2L);
		paymentDTO.setStatus("PAGADO");
		this.paymentDTO2 = paymentDTO;
	}
	
	private void setMemoryPaymentDTO() {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setAmount(100.50);
		paymentDTO.setAccountHolder("Juan Perez");
		paymentDTO.setPaymentReceiver("Jose Hernandez");
		paymentDTO.setDescription("pago de material");
		paymentDTO.setNumberProducts(3);
		paymentDTO.setPaymentId(2L);
		paymentDTO.setStatus("PAGADO");
		this.paymentDTO = paymentDTO;
	}
	
	private void setMemoryPaymentEntity() {
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setAmount(100.50);
		paymentEntity.setAccountHolder("Juan Perez");
		paymentEntity.setPaymentReceiver("Jose Hernandez");
		paymentEntity.setDescription("pago de material");
		paymentEntity.setNumberProducts(3);
		paymentEntity.setPaymentId(2L);
		paymentEntity.setStatus("PAGADO");
		paymentEntity.setCreateDate(new Date());
		paymentEntity.setUpdateDate(new Date());
		paymentEntity.setUser("system");
		this.paymentEntity = paymentEntity;
	}
	


}
