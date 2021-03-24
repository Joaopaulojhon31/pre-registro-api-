package com.webrecivil.api.monta.xml;
import java.util.Date;

import lombok.Data;

@Data
public class DadosPaiXml {
	
	private String paN = ""; //NOME PAI
	
	private String paCPF = ""; //CPF PAI
	
	private int paI; //IDADE PAI
	
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
	
	private String paEc = ""; //NÃO GERA
	
	private String paCEP = ""; //RESIDENCIA CEP PAI - NÃO GERA
	
	private String paP = ""; //PROFISSAO PAI
	
	private Date paDN; //DATA NASCIMENTO PAI
	
	private String paDI = ""; //DOCUMENTO PAI
	
	private String paTDI = ""; //TIPO DOCUMENTO PAI
	
	private String paPaN = ""; //FILIAÇAO AVO - PAI
	
	private Boolean paPaF; //FILIAÇÃO AVÔ - PAI - FALECIDO - NAO GERA
	
	private String paMaN = ""; //FILIACAO AVO - PAI
	
	private Boolean paMaF; //FILIACAO AVO - PAI - FALECIDA - NAO GERA
}
