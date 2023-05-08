package br.edu.utfpr.td.webservice;

import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;
import br.edu.utfpr.td.webservice.regras.IRegrasBoletim;


@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.webservice")
public class Main {
	@Autowired
	CSVLeitor reader;
	@Autowired
	IRegrasBoletim regrasBoletim;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}
	
	@PostConstruct
	public void init() throws ParseException {
		System.out.println("Inicio do programa");
		try {
			List<BoletimFurtoVeiculo> boletins =  reader.lerArquivoCsv("C:\\Users\\joau\\Desktop\\João Marcos\\Faculdade\\TSI-5-Periodo\\Topicos avançados\\repositorio-tsi\\ws-boletim-furto-veiculo\\webservice\\src\\main\\java\\br\\edu\\utfpr\\td\\webservice\\furtos.csv");
			boletins.stream().forEach(regrasBoletim::cadastrarBoletim);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
