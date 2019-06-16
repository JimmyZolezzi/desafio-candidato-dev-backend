package com.srmasset.thcepdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srmasset.business.EnderecoService;

import srm.srmassset.pojos.Endereco;
import srm.srmassset.pojos.ResponseDefault;

/**
 * endpoints de serviços a busca de endereço
 * @author ledzo
 *
 */
@RestController
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	/**
	 * Busca o endereço por cep
	 * @param cep
	 * @return
	 */
	@Cacheable(value = "post-single", key = "#cep")
	@GetMapping("/buscar-endereco/{cep}")
	public ResponseDefault<Endereco> buscarEndereco(@PathVariable(name = "cep") String cep){
		
		return enderecoService.findEnderecoByCEP(cep);
		
	}
	/**
	 * Busca de endereco por cep, exemplo usando hystrix
	 * @param cep
	 * @return
	 */
	@Cacheable(value = "post-single", key = "#cep")
	@GetMapping("/buscar-endereco-hystrix/{cep}")
	public ResponseDefault<Endereco> buscarEnderecoHystrix(@PathVariable(name = "cep") String cep){
		
		return enderecoService.findEnderecoByCEPHystrix(cep);
		
	}
	
	/**
	 * Busca lista de endereco por lista ceps
	 * @param ceps
	 * @return
	 */
	@Cacheable(value = "post-single", key = "#ceps")
	@PostMapping("/buscar-enderecos")
	public List<Endereco> buscarEnderecos(@RequestBody List<String> ceps){
		
		return enderecoService.findEnderecosByCEP(ceps);
		
	}
}
