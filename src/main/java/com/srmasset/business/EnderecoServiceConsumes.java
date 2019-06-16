package com.srmasset.business;

import srm.srmassset.pojos.Endereco;

/**
 * Interface de consumo do service de busco de endereco por cep
 * @author ledzo
 *
 */
public interface EnderecoServiceConsumes {
	
	public Endereco findEnderecoByCep(String cep);
}
