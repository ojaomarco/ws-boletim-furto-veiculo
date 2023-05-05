package br.edu.utfpr.td.webservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;

@Component
public class InMemoriaBoletim implements IBoletimDao{
	private ArrayList<BoletimFurtoVeiculo> boletinsInMemoria = new ArrayList<>();
	@Override
	public void gravar(BoletimFurtoVeiculo boletim) {
		boletinsInMemoria.add(boletim);
		System.out.println("Boletim registrado...");  
	}

	@Override
	public BoletimFurtoVeiculo ler(String idBoletim) {
		return null;
	}

	

	@Override
	public List<BoletimFurtoVeiculo> lerTodos() {
		return boletinsInMemoria;
	}

	public BoletimFurtoVeiculo getById(int id){
		return boletinsInMemoria.stream().filter(bo -> bo.getId() == id).collect(Collectors.toList()).get(0);
	}

	@Override
	public void editar(int id, BoletimFurtoVeiculo boletim) {
		int posBo = boletinsInMemoria.indexOf(boletinsInMemoria.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0));
		boletinsInMemoria.set(posBo, boletim);
		System.out.println("Boletim editado...");
	}

	@Override
	public void remover(int id) {
		int posBo = boletinsInMemoria.indexOf(boletinsInMemoria.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0));
		boletinsInMemoria.remove(posBo);
	}
}
