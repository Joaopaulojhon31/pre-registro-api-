package com.webrecivil.api.monta.xml;

import java.util.Date;

import lombok.Data;

@Data
public class DadosDeclaranteXml {
	
	private String deOP = ""; //TIPO DECLARANTE NA SOLICITAÇÃO
	private String deT = ""; //TIPO DECLARAÇÃO
	private String deN = ""; //NOME DECLARANTE
	private String deDI = ""; //DOCUMENTO DECLARANTE
	private String deTDI = ""; //TIPO DOCUMENTO DECLARANTE
	private Date deDN ; //DATA NASCIMENTO CRIANÇA
	private String deP = ""; //PROFISSÃO DECLARANTE
	private String deNc = ""; //NACIONALIDADE DECLARANTE
	private String deU = ""; //UF RESIDENCIA DECLARANTE
	private String deM = ""; //MUNICIPIO RESIDENCIA DECLARANTE
	private String deEb = ""; //BAIRRO RESIDENCIA DECLARANTE
	private String deEl = ""; //LOGRADOURO RESIDENCIA DECLARANTE
	private String deEn = ""; //NUMERO RESIDENCIA DECLARANTE
	private String deEc = ""; //COMPLEMENTO RESIDENCIA DECLARANTE
	private String deDPO = ""; //DADOS DO PROCESSO
	private String deDPA = ""; //DADOS DA PROCURAÇÃO
}
