package com.webrecivil.api.monta.xml;

import java.util.Date;

import lombok.Data;

@Data
public class DadosDeclaranteXml {
	
	private String deOP = ""; //TIPO DECLARANTE NA SOLICITACAO
	private String deT = ""; //TIPO DECLARACAO
	private String deN = ""; //NOME DECLARANTE
	private String deDI = ""; //DOCUMENTO DECLARANTE
	private String deTDI = ""; //TIPO DOCUMENTO DECLARANTE
	private Date deDN ; //DATA NASCIMENTO CRIANCA
	private String deP = ""; //PROFISSAO DECLARANTE
	private String deNc = ""; //NACIONALIDADE DECLARANTE
	private String deU = ""; //UF RESIDENCIA DECLARANTE
	private String deM = ""; //MUNICIPIO RESIDENCIA DECLARANTE
	private String deEb = ""; //BAIRRO RESIDENCIA DECLARANTE
	private String deEl = ""; //LOGRADOURO RESIDENCIA DECLARANTE
	private String deEn = ""; //NUMERO RESIDENCIA DECLARANTE
	private String deEc = ""; //COMPLEMENTO RESIDENCIA DECLARANTE
	private String deDPO = ""; //DADOS DO PROCESSO
	private String deDPA = ""; //DADOS DA PROCURAÇÃO
	
	public String converteTipoDeclaracao() {
		if (deT == null) {
			return "";
		}
		switch (deT) {
		case "Sem restrição":
			deT = "1";
			break;
		case "Representando o pai":
			deT = "2";
		case "Representando a mãe":
			deT = "3";
		case "Assistido(a) pelo Tutor ou responsável":	
		    deT = "4";
		case "Autorizado pelo Juiz":
			deT = "5";
		case "Por procuração":
			deT = "6";
		case "Declarante emancipado":
			deT = "7";
		case "Mãe presente":
			deT = "8";
		case "Mãe ausente":
			deT = "9";
		case "Mãe ausente com documentação":
			deT = "10";
		case "Mandado":
		    deT = "11";
		case "Declarante Analfabeto":
			deT = "12";
			break;
		}
		return deT;
	}
}
