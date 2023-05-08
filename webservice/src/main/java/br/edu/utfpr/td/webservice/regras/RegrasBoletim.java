package br.edu.utfpr.td.webservice.regras;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.webservice.dao.IBoletimDao;
import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;
import br.edu.utfpr.td.webservice.modelos.Veiculo;

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
	public void excluirBoletim(int id) {
		boletimDAO.remover(id);		
	}

	@Override
	public void alterarBoletim(int id, BoletimFurtoVeiculo boletim) {
		boletimDAO.editar(id, boletim);
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

	@Override
	public List<BoletimFurtoVeiculo> boletinsPorCidade(String cidade){
		return boletimDAO.getBoletinsPorCidade(cidade);
	}
	
	public List<String> validarBoletim(BoletimFurtoVeiculo boletim) {
	    List<String> erros = new ArrayList<String>();
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	    Set<ConstraintViolation<BoletimFurtoVeiculo>> violations = validator.validate(boletim);
	    for (ConstraintViolation<BoletimFurtoVeiculo> violation : violations) {
	        erros.add(violation.getMessage());
	    }
	    
	    return erros;
	}

	@Override
	public List<BoletimFurtoVeiculo> boletinsPorPeriodo(String periodo) {
		 return boletimDAO.getBoletinsPorPeroiodo(periodo);
	}

	@Override
	public List<Veiculo> veiculosPorCor(String cor) {
		return boletimDAO.getVeiculosPorCor(cor);
	}

	@Override
	public List<Veiculo> veiculosPorPlaca(String placa) {
		return boletimDAO.getVeiculosPorPlaca(placa);
	}

	@Override
	public List<Veiculo> veiculosPorTipo(String tipo) {
		return boletimDAO.getVeiculosPorTipo(tipo);
	}
	
}
