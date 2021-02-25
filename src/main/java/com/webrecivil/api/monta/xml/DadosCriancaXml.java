package com.webrecivil.api.monta.xml;

import java.util.Date;

import lombok.Data;

@Data
public class DadosCriancaXml {

	private String crN = ""; //NOME CRIN�A
	
	private String crS = ""; //SEXO CRIAN�A
	
	private String crDt ; //DATA NASCIMENTO CRIAN�A
	
	private String crH; //HORA NASCIMENTO
	
	private String crDNV = ""; //DNV CRIAN�A
	
	private String crNatUF = ""; //NATURALIDADE UF CRIAN�A
	
	private String crNatMun = ""; //NATURALIDADE
}
