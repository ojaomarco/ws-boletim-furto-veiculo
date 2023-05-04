package br.edu.utfpr.td.cotsi.webservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.modelos.BoletimFurtoVeiculo;

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
	public void remover(String idBoletim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoletimFurtoVeiculo> lerTodos() {
		return boletinsInMemoria;
	}

	public BoletimFurtoVeiculo getById(int id){
		return boletinsInMemoria.stream().filter(bo -> bo.getId() == id).collect(Collectors.toList()).get(0);
	}

}
