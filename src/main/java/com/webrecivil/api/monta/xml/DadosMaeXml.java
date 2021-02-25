package com.webrecivil.api.monta.xml;

import java.util.Date;

import lombok.Data;

@Data
public class DadosMaeXml {

	private String maN = ""; //NOME DA M�E
	private String maCPF = ""; //CPF M�E
	private int maI ; // IDADE M�E
	private String maNU = ""; // NATURALIDADE UF M�E
	private String maNM = ""; // NATURALIDADE M�E
	private String maND = ""; //DISTRITO NATURALIDADE M�E
	private String maNC = ""; // NACIONALIDADE M�E
	private String maU = ""; // RESIDENCIA UF M�E
	private String maM = ""; // RESIDENCIA MUNICIPIO M�E
	private String maD = ""; // RESIDENCIA DISTRITO M�E
	private String maEb = ""; //RESIDENCIA BAIRRO M�E
	private String maEl = ""; //RESIDENCIA LOGRADOURO M�E
	private String maEn ; //RESIDENCIA NUMERO M�E
	private String maEc = ""; //N�O � GERADO
	private String maCEP = ""; //RESIDENCIA CEP MAE - N�O GERA
	private String maP = ""; //PROFISS�O M�E
	private String maDN; //DATA NASCIMENTO M�E
	private String maDI = ""; //DOCUMENTO M�E
	private String maTDI = ""; //TIPO DOCUMENTO M�E
	private String maPaN = ""; //FILIA��O AV� - M�E
	private Boolean maPaF; //FILIA��O AV� - M�E - FALECIDO?
	private String maMaN = ""; //FILIA��O AV� - M�E
	private Boolean maMaF; //FILIA��O AV� - M�E - FALECIDA?
}
