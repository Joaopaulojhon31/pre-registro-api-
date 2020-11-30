package com.webrecivil.api;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import com.webrecivil.api.service.SalvarPreRegistroService;

@SpringBootApplication
public class ApiCertidaoApplication {


	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SpringApplication.run(ApiCertidaoApplication.class, args);
	
		
	}
}
