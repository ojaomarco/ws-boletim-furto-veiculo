package br.edu.utfpr.td.webservice.modelos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Endereco
{	@NotBlank (message = "Logradouro não pode estar em branco")
	private String logradouro;
	@NotNull (message= "Numero tem que ser válido")
	private int numero;
	@NotBlank (message = "Bairro não pode estar em branco")
	private String bairro;
	@NotBlank (message = "Cidade endereço não pode estar em branco")
	private String cidade;
	@NotBlank (message = "Estado não pode estar em branco")
	private String estado;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
