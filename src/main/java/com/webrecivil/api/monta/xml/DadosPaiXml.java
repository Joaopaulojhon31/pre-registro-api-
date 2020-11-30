package com.webrecivil.api.monta.xml;

import lombok.Data;

@Data
public class DadosPaiXml {
	
	private String paN = ""; //NOME PAI
	
	private String paCPF = ""; //CPF PAI
	
	private String paI; //IDADE PAI
	
	private String paNU = ""; //NATURALIDADE UF PAI
	
	private String paNM = ""; //MUNICIPIO NATURALIDADE PAI
	
	private String paND = ""; //DISTRITO NATURALIDADE PAI
	
	private String paNC = ""; //NACIONALIDADE PAI
	
	private String paU = ""; //RESIDENCIA UF PAI
	
	private String paM = ""; //RESIDENCIA MUNICIPIO PAI
	
	private String paD = ""; //DISTRITO RESIDENCIA PAI
	
	private String paEb = ""; //RESIDENCIA BAIRRO PAI
	
	private String paEl = ""; //RESIDENCIA LOGRADOURO PAI
	
	private String paEn = ""; //RESIDENCIA NUMERO PAI
	
	private String paEc = ""; //N�O GERA
	
	private String paCEP = ""; //RESIDENCIA CEP PAI - N�O GERA
	
	private String paP = ""; //PROFISS�O PAI
	
	private String paDN = ""; //DATA NASCIMENTO PAI
	
	private String paDI = ""; //DOCUMENTO PAI
	
	private String paTDI = ""; //TIPO DOCUMENTO PAI
	
	private String paPaN = ""; //FILIA��O AV� - PAI
	
	private boolean paPaF; //FILIA��O AV� - PAI - FALECIDO? - N�O GERA
	
	private String paMaN = ""; //FILIA��O AV� - PAI
	
	private boolean paMaF; //FILIA��O AV� - PAI - FALECIDA? - N�O GERA
}
