package com.banco.base.codeChallenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.base.codeChallenge.dto.PaymentDTO;
import com.banco.base.codeChallenge.service.MessageService;
import com.banco.base.codeChallenge.service.PaymentsService;
import com.banco.base.codeChallenge.utils.Response;


@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/payments")
public class PaymentsController implements PaymentsControllerI{

	final static Logger LOGGER = LoggerFactory.getLogger(PaymentsController.class);

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private PaymentsService paymentsService;

	@Override
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Response<PaymentDTO>> savePayment(@RequestBody PaymentDTO paymentDTO) {
        Response<PaymentDTO> response = null;
        try {
            response = new Response<>(paymentsService.savePayment(paymentDTO), messageService.getMessage("api.generic.messages.1004"));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            response = new Response<>(new PaymentDTO(), messageService.getMessage("api.generic.error.messages.1000") + ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

	@Override
	@GetMapping(path = "/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<PaymentDTO>> getPayment(@PathVariable("paymentId") Long paymentId) {
		Response<PaymentDTO> response = null;
        try {
            response = new Response<>(paymentsService.getPayment(paymentId), messageService.getMessage("api.generic.messages.1008"));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            response = new Response<>(new PaymentDTO(), messageService.getMessage("api.generic.error.messages.1000") + ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
	}

	@Override
	@PutMapping(path = "/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<PaymentDTO>> updatePayment(@PathVariable("paymentId") Long paymentId, @RequestBody PaymentDTO paymentDTO) {
		Response<PaymentDTO> response = null;
        try {
            response = new Response<>(paymentsService.updatePayment(paymentId, paymentDTO), messageService.getMessage("api.generic.messages.1005"));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            response = new Response<>(new PaymentDTO(), messageService.getMessage("api.generic.error.messages.1000") + ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
	}
}
