package br.edu.utfpr.td.webservice.modelos;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Veiculo 
{	@NotNull (message= "ano tem que ser válido")
	private int anoFabricacao;
	@NotBlank (message = "Cor do veiculo não pode estar em branco")
	private String cor;
	@NotBlank (message = "Marca do veiculo não pode estar em branco")
	private String marca;
	@NotBlank (message = "Tipo do veiculo não pode estar em branco")
	private String tipoVeiculo;
	@Valid
	private Emplacamento emplacamento;
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public Emplacamento getEmplacamento() {
		return emplacamento;
	}
	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}
	
	
}
