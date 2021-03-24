package com.webrecivil.api.monta.xml;

import lombok.Data;

@Data
public class DadosMaeXml {

	private String maN = ""; //NOME DA MAE
	private String maCPF = ""; //CPF MAE
	private int maI ; // IDADE MAE
	private String maNU = ""; // NATURALIDADE UF MAE
	private String maNM = ""; // NATURALIDADE MAE
	private String maND = ""; //DISTRITO NATURALIDADE MAE
	private String maNC = ""; // NACIONALIDADE MAE
	private String maU = ""; // RESIDENCIA UF MAE
	private String maM = ""; // RESIDENCIA MUNICIPIO MAE
	private String maD = ""; // RESIDENCIA DISTRITO MAE
	private String maEb = ""; //RESIDENCIA BAIRRO MAE
	private String maEl = ""; //RESIDENCIA LOGRADOURO MAE
	private String maEn ; //RESIDENCIA NUMERO MAE
	private String maEc = ""; //NAO E GERADO
	private String maCEP = ""; //RESIDENCIA CEP MAE - NAO GERA
	private String maP = ""; //PROFISSAO MAE
	private String maDN; //DATA NASCIMENTO MAE
	private String maDI = ""; //DOCUMENTO MAE
	private String maTDI = ""; //TIPO DOCUMENTO MAE
	private String maPaN = ""; //FILIAÇAO AVO - MAE
	private Boolean maPaF; //FILIAÇAO AVO - MAE - FALECIDO
	private String maMaN = ""; //FILIAÇAO AVO - MAE
	private Boolean maMaF; //FILIAÇAO AVO - MAE - FALECIDA
}
