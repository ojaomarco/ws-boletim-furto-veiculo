package br.edu.utfpr.td.webservice;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;
import br.edu.utfpr.td.webservice.modelos.Emplacamento;
import br.edu.utfpr.td.webservice.modelos.Endereco;
import br.edu.utfpr.td.webservice.modelos.Parte;
import br.edu.utfpr.td.webservice.modelos.Veiculo;

@Component
public class CSVLeitor {
	
	public List<BoletimFurtoVeiculo> lerArquivoCsv(String caminhoArquivo) throws IOException, CsvException, ParseException {
		List<BoletimFurtoVeiculo> boletins = new ArrayList<>();
	    FileReader reader = new FileReader(caminhoArquivo);
	    CSVParser parser = new CSVParserBuilder().withSeparator('\t').build();
	    CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(1).build(); // Ignora a primeira linha, que contém os cabeçalhos
	    String[] linha;
	    
	    while ((linha = csvReader.readNext()) != null) {
	    	BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
	    	boletim.setDataOcorrencia(parseData(linha[5]));
	        boletim.setPeriodoOcorrencia(linha[7]);
	      
	        Endereco endereco = new Endereco();
	        endereco.setLogradouro(linha[13]);
	        endereco.setNumero(Integer.parseInt(linha[14]));
	        endereco.setBairro(linha[15]);
	        endereco.setCidade(linha[16]);
	        endereco.setEstado(linha[17]);
	        boletim.setLocalOcorrencia(endereco);
	        
	        ArrayList<Parte> partes = new ArrayList<>();
	        Parte parte = new Parte();
	        parte.setEmail("d");
	        parte.setNome("a");
	        parte .setTelefone("a");
	        partes.add(parte);
	        //boletim.setPartes(partes);
	        
	        Emplacamento emplacamento = new Emplacamento();
	        emplacamento.setCidade(linha[46]);
	        emplacamento.setEstado(linha[45]);
	        emplacamento.setPlaca(linha[44]);
	        
	        Veiculo veiculo = new Veiculo();
	        veiculo.setEmplacamento(emplacamento);
	        veiculo.setCor(linha[47]);
	        veiculo.setMarca(linha[48]);
	        veiculo.setTipoVeiculo(linha[51]);
	        
	        try {
	        	veiculo.setAnoFabricacao(Integer.parseInt(linha[49]));
			} catch (Exception e) {
				veiculo.setAnoFabricacao(0);
			} 
	        
	        boletim.setVeiculoFurtado(veiculo);
	        boletins.add(boletim);
	    }
	    
	    csvReader.close();
	    return boletins;
	}
	
	private Date parseData(String dataStr) throws ParseException {
	    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	    return formatoData.parse(dataStr);
	}

}
