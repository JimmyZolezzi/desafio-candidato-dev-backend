package com.srmasset.business.impl;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.srmasset.business.EnderecoServiceConsumes;

import srm.srmassset.pojos.Endereco;

/**
 * Consumo de Servico de busca de endereço por cep
 * @author ledzo
 *
 */
@Service
public class EnderecoServiceConsumesImpl implements EnderecoServiceConsumes{

	private final String url = "https://zuul.trusthub.com.br/orchestrator/v1/obter-endereco-por-cep/";
	@Override
	
	/**
	 * Chamada de serviço externo: Busca de endereço por cep
	 */
	public Endereco findEnderecoByCep(String cep) {

		StringBuilder sBuilderUrl = new StringBuilder();
		sBuilderUrl.append(url);
		if(cep != null) {
			sBuilderUrl.append(cep);
		}
		String url = sBuilderUrl.toString();
		
		HttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);

		RestTemplate restTemplate = new RestTemplate(requestFactory);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<Endereco> responseJson =  restTemplate.getForEntity(url, Endereco.class);
		
		return responseJson.getBody();
	}

	
}
