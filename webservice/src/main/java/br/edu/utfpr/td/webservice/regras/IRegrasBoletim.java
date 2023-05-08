package br.edu.utfpr.td.webservice.regras;

import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;
import br.edu.utfpr.td.webservice.modelos.Veiculo;
@Component
public interface IRegrasBoletim 
{
	public void cadastrarBoletim(BoletimFurtoVeiculo boletim);
	public void excluirBoletim(int id);
	public void alterarBoletim(int id, BoletimFurtoVeiculo boletim);
	public BoletimFurtoVeiculo boletimById(int id) ;
	public List<BoletimFurtoVeiculo> listarBoletins();
	public boolean boletimIsValid(BoletimFurtoVeiculo boletim);
	public List<BoletimFurtoVeiculo> boletinsPorCidade(String cidade);
	public List<String> validarBoletim(BoletimFurtoVeiculo boletim);
	public List<BoletimFurtoVeiculo> boletinsPorPeriodo(String periodo);
	public List<Veiculo> veiculosPorCor(String cor);
	public List<Veiculo> veiculosPorPlaca(String placa);
	public List<Veiculo> veiculosPorTipo(String tipo);
	
}
