package br.edu.utfpr.td.cotsi.webservice.regras;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.dao.IBoletimDao;
import br.edu.utfpr.td.cotsi.webservice.modelos.BoletimFurtoVeiculo;

@Component
public class RegrasBoletim implements IRegrasBoletim
{
	@Autowired
	private IBoletimDao boletimDAO;
	
	@Override
	public void cadastrarBoletim(BoletimFurtoVeiculo boletim) {
		boletimDAO.gravar(boletim);
	}

	@Override
	public void excluirBoletim(BoletimFurtoVeiculo boletim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarBoletim(BoletimFurtoVeiculo boletim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoletimFurtoVeiculo boletimById(int id){
		if(id<1){
			return null;
		}else{
			return boletimDAO.getById(id);
		}
	}


	@Override
	public List<BoletimFurtoVeiculo> listarBoletins() {
		return boletimDAO.lerTodos();
	}

	@Override
	public boolean boletimIsValid(BoletimFurtoVeiculo boletim) {
		boolean valid = false;
		try {
			valid = boTemAtributoNulo(boletim);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return valid;
	}

	public boolean emailIsValid(String email){
		return email.contains("@");
	}

	public boolean boTemAtributoNulo(Object objeto) throws IllegalAccessException{
		for (Field campo : objeto.getClass().getDeclaredFields()) {
			campo.setAccessible(true);
			if (campo.get(objeto) == null) return true;
		}
		return false;
	}
	
}
