package com.srmasset.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.DefaultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.srmasset.business.EnderecoService;
import com.srmasset.business.EnderecoServiceConsumes;

import srm.srmassset.pojos.Endereco;
import srm.srmassset.pojos.ResponseDefault;

/**
 * Serviço de busca de endereços
 * @author ledzo
 *
 */
@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoServiceConsumes enderecoServiceConsumes;
	
	/**
	 * Busca de endereco por cep
	 * @param cep
	 * @return  ResponseDefault<Endereco>
	 */
	@Override
	public ResponseDefault<Endereco> findEnderecoByCEP(String cep) {
		
		try {
			Endereco endereco = enderecoServiceConsumes.findEnderecoByCep(cep);
			ResponseDefault<Endereco> response = new ResponseDefault<Endereco>(endereco, ResponseDefault.SUCESSO);
			return response;
			
		}catch(Exception e) {
			
			return  new ResponseDefault<Endereco>(null, ResponseDefault.ERRO);
		}
	}

	/**
	 * Busca de endereco utilizando tratamento Hystrix(caso haja uma falha ao metodo)
	 * @param cep
	 * @return ResponseDefault<Endereco>
	 */
	@Override
	@HystrixCommand(fallbackMethod = "findEnderecoErro")
	public ResponseDefault<Endereco> findEnderecoByCEPHystrix(String cep) {
		
		Endereco endereco = enderecoServiceConsumes.findEnderecoByCep(cep);
		ResponseDefault<Endereco> response = new ResponseDefault<Endereco>(endereco, ResponseDefault.SUCESSO);
		return response;
		
	}

	/** metodo chamada no caso de falha na busca de endereço por cep */
	public ResponseDefault<Endereco> findEnderecoErro(String cep) {
		
		return new ResponseDefault<Endereco>(null, ResponseDefault.ERRO);
	}

	
	/**
	 * Busca enderecos por lista de ceps
	 * @param ceps
	 * @return
	 */
	@Override
	public List<Endereco> findEnderecosByCEP(List<String> ceps) {
		
		List<Endereco> enderecos = new ArrayList<Endereco>();

		for (String cep : ceps) {
			
			Endereco endereco = enderecoServiceConsumes.findEnderecoByCep(cep);
			enderecos.add(endereco);
			
		}
		
		return enderecos;
	}
}
