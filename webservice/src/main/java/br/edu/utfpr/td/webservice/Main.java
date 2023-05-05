package br.edu.utfpr.td.webservice;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.webservice")
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}
	
	@PostConstruct
	public void init() {
		System.out.println("Inicio do programa");
	}

}
