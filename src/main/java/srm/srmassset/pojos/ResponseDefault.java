package srm.srmassset.pojos;

import java.io.Serializable;

/**
 * Response generico utilizado no retorno dos serviços
 * @author ledzo
 *
 * @param <T>
 */
public class ResponseDefault <T> implements Serializable {
	
	private static final long serialVersionUID = 7286330362941464903L;
	/** Responsta do tipo do objeto */
	private Object response;
	/** mensagem de retorno do serviço */
	private String msg;
	/** total de Registros */
	private Long totalRegistros;
	
	public static final String SUCESSO = "SUCESSO";
	public static final String ERRO = "ERRO";
	
	/**
	 *  Construtor para objeto de resposta de serviço
	 * @param objeto
	 * @param totalRegistros
	 * @param msg
	 */
	public ResponseDefault(T objeto, Long totalRegistros, String msg) {
		this.response = objeto;
		this.totalRegistros = totalRegistros;
		this.msg = msg;
		
	}
	
	public ResponseDefault() {
	
	}
	
	/**
	 * Construtor para objeto de resposta de serviço
	 * @param objeto
	 * @param msg
	 */
	public ResponseDefault(T objeto, String msg) {
		if(SUCESSO.equals(msg)) {
			this.totalRegistros = 1L;
		}else {
			this.totalRegistros = 0L;
		}
		this.response = objeto;
		this.msg = msg;
	}
	
	/**
	 * Construtor para objeto de resposta de serviço
	 * 
	 * @param objeto
	 */
	public ResponseDefault(T objeto) {
		this.totalRegistros = 0L;
		this.response = objeto;
		this.msg = objeto.toString();
	}


	/**
	 * Retorna o objeto de resposta do serviço
	 * @return Object
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * Obtem a mensagem resposta de serviço podendo ser SUCESSO OU ERRO
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Obtem o total de registros retornado pelo serviço
	 * @return totalRegistros
	 */
	public Long getTotalRegistros() {
		return totalRegistros;
	}

	/**
	 * Atribui o total de registros do serviço
	 * @param totalRegistros
	 */
	public void setTotalRegistros(Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

}
