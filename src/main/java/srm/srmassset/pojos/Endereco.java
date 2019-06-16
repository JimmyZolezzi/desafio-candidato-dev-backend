package srm.srmassset.pojos;

import java.io.Serializable;

/**
 * Modelo do objeto de endereço
 * @author ledzo
 *
 */
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 2049938607180122210L;
	
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	

}
