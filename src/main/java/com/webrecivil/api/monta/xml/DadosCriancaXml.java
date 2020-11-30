package com.webrecivil.api.monta.xml;

import java.security.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class DadosCriancaXml {

	private String crN = ""; //NOME CRIN�A
	
	private String crS = ""; //SEXO CRIAN�A
	
	private Date crDt ; //DATA NASCIMENTO CRIAN�A
	
	private Date crH; //HORA NASCIMENTO
	
	private String crDNV = ""; //DNV CRIAN�A
	
	private String crNatUF = ""; //NATURALIDADE UF CRIAN�A
	
	private String crNatMun = ""; //NATURALIDADE
}
