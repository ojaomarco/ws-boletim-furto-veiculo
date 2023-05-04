package br.edu.utfpr.td.cotsi.webservice.regras;

import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.modelos.BoletimFurtoVeiculo;
@Component
public interface IRegrasBoletim 
{
	public void cadastrarBoletim(BoletimFurtoVeiculo boletim);
	public void excluirBoletim(BoletimFurtoVeiculo boletim);
	public void alterarBoletim(BoletimFurtoVeiculo boletim);
	public BoletimFurtoVeiculo boletimById(int id) ;
	public List<BoletimFurtoVeiculo> listarBoletins();

	public boolean boletimIsValid(BoletimFurtoVeiculo boletim);
}
