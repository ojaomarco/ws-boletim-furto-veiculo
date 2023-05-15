package br.edu.utfpr.td.webservice.modelos;

import javax.validation.constraints.NotBlank;

public class Emplacamento 
{	@NotBlank (message = "Placa do veiculo não pode estar em branco")
	private String placa;
	@NotBlank (message = "UF da placa do veiculo não pode estar em branco")
	private String estado;
	@NotBlank (message = "Cidade da placa do veiculo não pode estar em branco")
	private String cidade;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
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
	
	
}
