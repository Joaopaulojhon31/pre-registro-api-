package com.webrecivil.api.monta.xml;

public class PreRegistroSolicitacao{
	
    private String codigoSolicitacao = "";
	private String h = ""; //CÓDIGO HASH
	private String uim = ""; //MUNICÍO UNIDADE INTERLIGADA
	private String uiu = ""; //UF UNIDADE INTERLIGADA
	private String uiN = ""; //NOME UNIDADE INTERLIGADA
	private String uiB = ""; //BAIRRO UNIDADE INTERLIGADA
	private String uiL = ""; //LOGRADOURO UNIDADE INTERLIGADA
	private String coCd = ""; //CÓDIGO UNIDADE INTERLIGADA
	private String crQ = ""; //QUANTIDADE DE CRIANÇAS
	private DadosCriancaXml cr;
	private DadosCriancaXml cr2;
	private DadosCriancaXml cr3;
	private DadosCriancaXml cr4;
	private DadosCriancaXml cr5;
	private String paDe = ""; //STATUS PAI
	private DadosPaiXml pa;
	private DadosMaeXml ma;
	private String de = "";
	private DadosDeclaranteXml deI;
	private DadosContatoXml co;
	
	public String converteTipoDeclarante() {
		if (de == null) {
			return "";
		}
		
		switch (de) {
		case "Mãe":
			de = "1";
			break;
		case "Pai":
			de = "2";
			break;
		case "Outro":
		    de = "4";
		    break;
		case "Mae":
			de = "1";
			break;
		default:
			de = "1";
			break;
		}
		return de;
	}
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public String getUim() {
		return uim;
	}
	public void setUim(String uim) {
		this.uim = uim;
	}
	public String getUiu() {
		return uiu;
	}
	public void setUiu(String uiu) {
		this.uiu = uiu;
	}
	public String getUiN() {
		return uiN;
	}
	public void setUiN(String uiN) {
		this.uiN = uiN;
	}
	public String getUiB() {
		return uiB;
	}
	public void setUiB(String uiB) {
		this.uiB = uiB;
	}
	public String getUiL() {
		return uiL;
	}
	public void setUiL(String uiL) {
		this.uiL = uiL;
	}
	public String getCoCd() {
		return coCd;
	}
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	public String getCrQ() {
		return crQ;
	}
	public void setCrQ(String crQ) {
		this.crQ = crQ;
	}
	public DadosCriancaXml getDadosCrianca1Xml() {
		return cr;
	}
	public void setDadosCrianca1Xml(DadosCriancaXml cr) {
		this.cr = cr;
	}
	public DadosPaiXml getDadosPaiXml() {
		return pa;
	}
	public void setDadosPaiXml(DadosPaiXml pa) {
		this.pa = pa;
	}
	public DadosMaeXml getDadosMaeXml() {
		return ma;
	}
	public void setDadosMaeXml(DadosMaeXml ma) {
		this.ma = ma;
	}
	public DadosDeclaranteXml getDadosDeclaranteXml() {
		return this.deI;
	}
	public void setDadosDeclaranteXml(DadosDeclaranteXml deI) {
		this.deI = deI;
	}
	public DadosContatoXml getDadosContatoXml() {
		return this.co;
	}
	public void setDadosContatoXml(DadosContatoXml co) {
		this.co = co;
	}
	public String getpaDe() {
		return this.paDe;
	}
	public void setpaDe(String paDe) {
		this.paDe = paDe;
	}
	public String getde() {
		return this.de;
	}
	public void setde(String de) {
		this.de = de;
	}
	public String getcodigoSolicitacao() {
		return this.codigoSolicitacao = codigoSolicitacao;
	}
	public void setcodigoSolicitacao(String codigoSolicitacao) {
		this.codigoSolicitacao = codigoSolicitacao;
	}
	public DadosCriancaXml getDadosCrianca2Xml() {
		return cr2;
	}
	public void setDadosCrianca2Xml(DadosCriancaXml cr2) {
		this.cr2 = cr2;
	}
	public DadosCriancaXml getDadosCrianca3Xml() {
		return cr3;
	}
	public void setDadosCrianca3Xml(DadosCriancaXml cr3) {
		this.cr3 = cr3;
	}
	public DadosCriancaXml getDadosCrianca4Xml() {
		return cr4;
	}
	public void setDadosCrianca4Xml(DadosCriancaXml cr4) {
		this.cr4 = cr4;
	}
	public DadosCriancaXml getDadosCrianca5Xml() {
		return cr5;
	}
	public void setDadosCrianca5Xml(DadosCriancaXml cr5) {
		this.cr5 = cr5;
	}
}
