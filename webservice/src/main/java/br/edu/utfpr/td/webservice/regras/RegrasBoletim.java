package br.edu.utfpr.td.webservice.regras;

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
import exceptions.ResourceNotFoundException;

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
	public BoletimFurtoVeiculo boletimById(int id) throws ResourceNotFoundException{
		return boletimDAO.getById(id);
	}


	@Override
	public List<BoletimFurtoVeiculo> listarBoletins() {
		return boletimDAO.lerTodos();
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
	    if(!emailIsValid(boletim.getPartes().get(0).getEmail())) erros.add("Email Invalido");
	    
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

	@Override
	public boolean boletimIsValid(BoletimFurtoVeiculo boletim) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean emailIsValid(String email) {
		return email.contains("@");
	}

	@Override
	public List<Veiculo> listarVeiculos() {
		return boletimDAO.getVeiculos();
	}
	
}
