package com.srmasset.business;


import java.util.List;

import srm.srmassset.pojos.Endereco;
import srm.srmassset.pojos.ResponseDefault;

/**
 * Inteface de busca de endereco por cep
 * @author ledzo
 *
 */
public interface EnderecoService {

	
	/**
	 * Busca de endereco por cep
	 * @param cep
	 * @return  ResponseDefault<Endereco>
	 */
	public ResponseDefault<Endereco> findEnderecoByCEP(String cep);
	/**
	 * Busca enderecos por lista de ceps
	 * @param ceps
	 * @return
	 */
	public List<Endereco> findEnderecosByCEP(List<String> ceps);
	/**
	 * Busca de endereco utilizando tratamento Hystrix(caso haja uma falha ao metodo)
	 * @param cep
	 * @return ResponseDefault<Endereco>
	 */
	public ResponseDefault<Endereco> findEnderecoByCEPHystrix(String cep);
}
