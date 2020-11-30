package com.webrecivil.api.monta.xml;

import java.security.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class DadosCriancaXml {

	private String crN = ""; //NOME CRINÇA
	
	private String crS = ""; //SEXO CRIANÇA
	
	private Date crDt ; //DATA NASCIMENTO CRIANÇA
	
	private Date crH; //HORA NASCIMENTO
	
	private String crDNV = ""; //DNV CRIANÇA
	
	private String crNatUF = ""; //NATURALIDADE UF CRIANÇA
	
	private String crNatMun = ""; //NATURALIDADE
}
