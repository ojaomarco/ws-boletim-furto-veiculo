package br.edu.utfpr.td.webservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;
import br.edu.utfpr.td.webservice.modelos.Veiculo;
import exceptions.ResourceNotFoundException;

@Component
public class InMemoriaBoletim implements IBoletimDao{
	private ArrayList<BoletimFurtoVeiculo> boletinsInMemoria = new ArrayList<>();
	private ArrayList<Veiculo> veiculosFurtados = new ArrayList<>();
	
	@Override
	public void gravar(BoletimFurtoVeiculo boletim) {
		veiculosFurtados.add(boletim.getVeiculoFurtado());
		boletinsInMemoria.add(boletim);
		System.out.println("Boletim registrado...");  
	}
	
	@Override
	public List<BoletimFurtoVeiculo> lerTodos() {
		return boletinsInMemoria;
	}
	
	public BoletimFurtoVeiculo getById(int id)throws ResourceNotFoundException{
		try {
			return boletinsInMemoria.stream().filter(bo -> bo.getId() == id).collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Não Encontrado...");
		}
	}

	@Override
	public void editar(int id, BoletimFurtoVeiculo boletim) throws ResourceNotFoundException{
		try {
			int posBo = boletinsInMemoria.indexOf(boletinsInMemoria.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0));
			boletim.setId(id);
			boletinsInMemoria.set(posBo, boletim);
			System.out.println("Boletim editado...");
		} catch (Exception e) {
			throw new ResourceNotFoundException("Erro ao editar, boletim não existe...");
		}
		
	}

	@Override
	public void remover(int id)throws ResourceNotFoundException{
		
		try {
			int posBo = boletinsInMemoria.indexOf(boletinsInMemoria.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0));
			boletinsInMemoria.remove(posBo);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Erro ao excluir, boletim não encontrado...");
		}
	}
	
	@Override
	public List<BoletimFurtoVeiculo> getBoletinsPorCidade(String cidade){
		return boletinsInMemoria.stream().filter(a -> a.getLocalOcorrencia().getCidade().equalsIgnoreCase(cidade)).toList();
	}

	@Override
	public List<BoletimFurtoVeiculo> getBoletinsPorPeroiodo(String periodo) {
		return boletinsInMemoria.stream().filter(a -> a.getPeriodoOcorrencia().equalsIgnoreCase(periodo)).toList();
	}

	@Override
	public List<Veiculo> getVeiculosPorCor(String cor) {
		return veiculosFurtados.stream().filter(v -> v.getCor().equalsIgnoreCase(cor)).toList();
	}

	@Override
	public List<Veiculo> getVeiculosPorPlaca(String placa) {
		return veiculosFurtados.stream().filter(v -> v.getEmplacamento().getPlaca().equalsIgnoreCase(placa)).toList();
	}

	@Override
	public List<Veiculo> getVeiculosPorTipo(String tipo) {
		return veiculosFurtados.stream().filter(v -> v.getTipoVeiculo().equalsIgnoreCase(tipo)).toList();
	}

	@Override
	public List<Veiculo> getVeiculos() {
		return veiculosFurtados;
	}
}
