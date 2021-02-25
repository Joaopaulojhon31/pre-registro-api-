package com.webrecivil.api.monta.xml;

import java.util.Date;

import lombok.Data;

@Data
public class DadosMaeXml {

	private String maN = ""; //NOME DA MÃE
	private String maCPF = ""; //CPF MÃE
	private int maI ; // IDADE MÃE
	private String maNU = ""; // NATURALIDADE UF MÃE
	private String maNM = ""; // NATURALIDADE MÃE
	private String maND = ""; //DISTRITO NATURALIDADE MÃE
	private String maNC = ""; // NACIONALIDADE MÃE
	private String maU = ""; // RESIDENCIA UF MÃE
	private String maM = ""; // RESIDENCIA MUNICIPIO MÃE
	private String maD = ""; // RESIDENCIA DISTRITO MÃE
	private String maEb = ""; //RESIDENCIA BAIRRO MÃE
	private String maEl = ""; //RESIDENCIA LOGRADOURO MÃE
	private String maEn ; //RESIDENCIA NUMERO MÃE
	private String maEc = ""; //NÃO É GERADO
	private String maCEP = ""; //RESIDENCIA CEP MAE - NÃO GERA
	private String maP = ""; //PROFISSÃO MÃE
	private String maDN; //DATA NASCIMENTO MÃE
	private String maDI = ""; //DOCUMENTO MÃE
	private String maTDI = ""; //TIPO DOCUMENTO MÃE
	private String maPaN = ""; //FILIAÇÃO AVÔ - MÃE
	private Boolean maPaF; //FILIAÇÃO AVÔ - MÃE - FALECIDO?
	private String maMaN = ""; //FILIAÇÃO AVÓ - MÃE
	private Boolean maMaF; //FILIAÇÃO AVÓ - MÃE - FALECIDA?
}
