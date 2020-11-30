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
	private String paDe = ""; //STATUS PAI
	private DadosPaiXml pa;
	private DadosMaeXml ma;
	private String de = "";
	private DadosDeclaranteXml deI;
	private DadosContatoXml co;
	
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
	public DadosCriancaXml getDadosCriancaXml() {
		return cr;
	}
	public void setDadosCriancaXml(DadosCriancaXml cr) {
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
}
