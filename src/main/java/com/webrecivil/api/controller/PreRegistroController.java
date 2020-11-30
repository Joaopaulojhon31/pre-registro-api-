package com.webrecivil.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webrecivil.api.entidade.PreRegistro;
import com.webrecivil.api.entidade.PreRegistroXML;
import com.webrecivil.api.exception.ApiException;
import com.webrecivil.api.service.GerarXMLService;
import com.webrecivil.api.service.SalvarPreRegistroService;
import com.webrecivil.api.service.SalvarXMLService;

@Controller
@RequestMapping("/preRegistro")
public class PreRegistroController {
	
	@Autowired
	private GerarXMLService buscaPeloCpfDaMae;
	@Autowired
	GerarXMLService busca ;
	@Autowired
	private SalvarPreRegistroService nome;
	@Autowired
	private SalvarXMLService inserirXMLService;
	@Autowired
	SalvarPreRegistroService cadastro1;
	
	@PostMapping("/buscar")
	public ResponseEntity<String> buscaCpfMae(@RequestBody String cpfMae, boolean isCartosoft){
	try {
		return new ResponseEntity<String>(buscaPeloCpfDaMae.gerarXML(cpfMae),HttpStatus.OK);
	} catch (ApiException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	}
	
	@GetMapping("/cadastroPreRegistro")
	public ResponseEntity<Object> salvarPreRegistro (@RequestBody PreRegistro cadastro ) throws ApiException{
	
		try {
		return  new ResponseEntity<Object>(nome.salvarPreRegistro(cadastro), HttpStatus.OK);
		}catch (ApiException e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		}
	
	
	
	
	@PostMapping("/salvarXMLPreRegistro")
	public ResponseEntity<PreRegistroXML> salvarXMLPreRegistro (@RequestBody String xml ) throws Exception{
		try {
			return  new ResponseEntity<PreRegistroXML>(inserirXMLService.inserirXML(xml), HttpStatus.CREATED);
		} catch (Exception e) {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
			headers.set("Erro", e.getMessage());
			return new ResponseEntity<PreRegistroXML>(headers, HttpStatus.BAD_REQUEST);
		}
	}
}
