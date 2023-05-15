package br.edu.utfpr.td.webservice.modelos;

import javax.validation.constraints.NotBlank;

public class Parte {
	@NotBlank (message = "Nome não pode estar em branco")
	private String nome;
	@NotBlank (message = "Email não pode estar em branco")
	private String email;
	@NotBlank (message = "Telefone não pode estar em branco")
	private String telefone;
	@NotBlank (message = "TipoEnvolvimento não pode estar em branco")
	private String tipoEnvolvimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipoEnvolvimento() {
		return tipoEnvolvimento;
	}
	public void setTipoEnvolvimento(String tipoEnvolvimento) {
		this.tipoEnvolvimento = tipoEnvolvimento;
	}
	
	
}
