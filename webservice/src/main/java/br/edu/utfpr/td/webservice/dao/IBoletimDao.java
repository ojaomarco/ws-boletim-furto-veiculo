package br.edu.utfpr.td.webservice.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;

@Component
public interface IBoletimDao {
	public void gravar(BoletimFurtoVeiculo boletim);
	public BoletimFurtoVeiculo ler(String idBoletim);
	public void remover(int id);
	public void editar(int id, BoletimFurtoVeiculo boletim);
	public List<BoletimFurtoVeiculo> lerTodos();
	public BoletimFurtoVeiculo getById(int id);
}
