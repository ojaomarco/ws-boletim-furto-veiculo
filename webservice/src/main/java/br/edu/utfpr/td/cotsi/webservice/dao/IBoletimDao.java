package br.edu.utfpr.td.cotsi.webservice.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.modelos.BoletimFurtoVeiculo;

@Component
public interface IBoletimDao {
	public void gravar(BoletimFurtoVeiculo boletim);
	public BoletimFurtoVeiculo ler(String idBoletim);
	public void remover(String idBoletim);
	public List<BoletimFurtoVeiculo> lerTodos();
	public BoletimFurtoVeiculo getById(int id);
}
