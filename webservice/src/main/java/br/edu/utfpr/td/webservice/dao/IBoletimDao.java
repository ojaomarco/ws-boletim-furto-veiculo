package br.edu.utfpr.td.webservice.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;
import br.edu.utfpr.td.webservice.modelos.Veiculo;

@Component
public interface IBoletimDao {
	public void gravar(BoletimFurtoVeiculo boletim);
	public void remover(int id);
	public void editar(int id, BoletimFurtoVeiculo boletim);
	public List<BoletimFurtoVeiculo> lerTodos();
	public BoletimFurtoVeiculo getById(int id);
	public List<BoletimFurtoVeiculo> getBoletinsPorCidade(String cidade);
	public List<BoletimFurtoVeiculo> getBoletinsPorPeroiodo(String periodo);
	public List<Veiculo> getVeiculosPorCor(String cor);
	public List<Veiculo> getVeiculosPorPlaca(String placa);
	public List<Veiculo> getVeiculosPorTipo(String tipo);
	public List<Veiculo> getVeiculos();
}
