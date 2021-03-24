package com.webrecivil.api.monta.xml;

import java.util.Date;

import lombok.Data;

@Data
public class DadosCriancaXml {

	private String crN = ""; //NOME CRINCA
	
	private String crS = ""; //SEXO CRIANCA
	
	private String crDt ; //DATA NASCIMENTO CRIANCA
	
	private String crH; //HORA NASCIMENTO
	
	private String crDNV = ""; //DNV CRIANCA
	
	private String crNatUF = ""; //NATURALIDADE UF CRIANCA
	
	private String crNatMun = ""; //NATURALIDADE
}
