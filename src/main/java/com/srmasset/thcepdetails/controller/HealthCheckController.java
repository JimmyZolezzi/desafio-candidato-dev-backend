package com.srmasset.thcepdetails.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Healthcheck
 * @author ledzo
 *
 */
@RestController
public class HealthCheckController {

	/**
	 * url para verificar a saude do serviço
	 * @return
	 */
	@GetMapping("/healthcheck")
	public String teste() {
		
		return "Nosso serviço está funcionando e recebendo requisições.";
	}
}
