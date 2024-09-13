package com.banco.base.codeChallenge.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banco.base.codeChallenge.dto.PaymentDTO;
import com.banco.base.codeChallenge.utils.Response;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/payments")
public interface PaymentsControllerI {

	@Tag(name = "Alta de pago", description = "Dar de alta un pago con al menos los siguientes atributos:\n"
			+ "– concepto\n" + "– cantidad de productos\n" + "– quién realiza el pago\n" + "– a quién se le paga\n"
			+ "– monto\n" + "– estatus del pago")
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<PaymentDTO>> savePayment(@RequestBody PaymentDTO paymentDTO);

	@Tag(name = "Consultar pago por Id", description = "Tener la capacidad de verificar el estatus del pago")
	@GetMapping(path = "/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<PaymentDTO>> getPayment(@PathVariable("paymentId") Long paymentId);

	@Tag(name = "Actualizar estatus por Id", description = "Tener la capacidad de cambiar el estatus del pago")
	@PutMapping(path = "/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<PaymentDTO>> updatePayment(@PathVariable("paymentId") Long paymentId, @RequestBody PaymentDTO paymentDTO);

}
