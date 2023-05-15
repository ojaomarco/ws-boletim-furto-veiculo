package br.edu.utfpr.td.webservice.modelos;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class BoletimFurtoVeiculo {
	private int id;
	@Valid
	private Date dataOcorrencia;
	@NotBlank (message = "Periodo não pode estar em branco")
	private String periodoOcorrencia;
	@Valid
	private List<Parte> partes;
	@Valid
	private Endereco localOcorrencia;
	@Valid
	private Veiculo veiculoFurtado;
	
	private static int count = 1;
	
	public BoletimFurtoVeiculo(){
		this.id = count;
		count++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	public String getPeriodoOcorrencia() {
		return periodoOcorrencia;
	}
	public void setPeriodoOcorrencia(String periodoOcorrencia) {
		this.periodoOcorrencia = periodoOcorrencia;
	}
	public List<Parte> getPartes() {
		return partes;
	}
	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}
	public Endereco getLocalOcorrencia() {
		return localOcorrencia;
	}
	public void setLocalOcorrencia(Endereco localOcorrencia) {
		this.localOcorrencia = localOcorrencia;
	}
	public Veiculo getVeiculoFurtado() {
		return veiculoFurtado;
	}
	public void setVeiculoFurtado(Veiculo veiculoFurtado) {
		this.veiculoFurtado = veiculoFurtado;
	}
	@Override
	public String toString() {
		return "BoletimFurtoVeiculo [id=" + id + ", dataOcorrencia=" + dataOcorrencia + ", periodoOcorrencia="
				+ periodoOcorrencia + ", partes=" + partes + ", localOcorrencia=" + localOcorrencia
				+ ", veiculoFurtado=" + veiculoFurtado + "]";
	}

	
}
