package com.webrecivil.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.webrecivil.api.entidade.Parametro;
import com.webrecivil.api.entidade.PreRegistro;
import com.webrecivil.api.exception.ApiException;
import com.webrecivil.api.monta.xml.DadosContatoXml;
import com.webrecivil.api.monta.xml.DadosCriancaXml;
import com.webrecivil.api.monta.xml.DadosDeclaranteXml;
import com.webrecivil.api.monta.xml.DadosMaeXml;
import com.webrecivil.api.monta.xml.DadosPaiXml;
import com.webrecivil.api.monta.xml.PreRegistroSolicitacao;
import com.webrecivil.api.repository.ParametroRepository;
import com.webrecivil.api.repository.PreRegistroRepository;

@Service
public class GerarXMLService {

	@Autowired
	private PreRegistroRepository preRegistroRepository;
	@Autowired
	private ParametroRepository parametroRepository;

	/*public PreRegistro buscaPreRegistroPeloCPFdaMae(String cpfMae) {
		return preRegistroRepository.buscaPeloCpfDaMae(cpfMae);
	}*/

	public String gerarXML(String cpfMae) throws ApiException {
		PreRegistro solicitacaoPreRegistro = retornaDadosDaSolicitacaoPreRegistro(cpfMae);
		
		if (solicitacaoPreRegistro == null || (!solicitacaoPreRegistro.getSituacaoSolicitacao().equals("2"))) {
			return null;
		}
		
		validaCPF(cpfMae);

		XStream xml = new XStream();
		PreRegistroSolicitacao sol = new PreRegistroSolicitacao();
		xml.alias("sol", PreRegistroSolicitacao.class);
		xml.aliasField("cr", PreRegistroSolicitacao.class, "cr2");
		xml.aliasField("cr", PreRegistroSolicitacao.class, "cr3");
		xml.aliasField("cr", PreRegistroSolicitacao.class, "cr4");
		xml.aliasField("cr", PreRegistroSolicitacao.class, "cr5");

		setaDadosXmlUnidadeInterligada(sol, solicitacaoPreRegistro);
		setaDadosCrianca(sol, solicitacaoPreRegistro);
		sol.setDadosPaiXml(setaDadosPai(solicitacaoPreRegistro));
		sol.setDadosMaeXml(setaDadosMae(solicitacaoPreRegistro));
		sol.setDadosDeclaranteXml(setaDadosDeclarante(solicitacaoPreRegistro));
		sol.setDadosContatoXml(setaDadosContatoXml(solicitacaoPreRegistro));
		
		return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n" + xml.toXML(sol);
	}
	
	//TODO: Método alternativo para gerar o XML enviando CNS e CPF, pois o Cartosoft consegue enviar apenas um parâmetro
	public String gerarXmlViaCRC(String cpfMae, String cnsCartorio) throws ApiException {
		PreRegistro solicitacaoPreRegistro = recuperaPreRegistroSolicitadoPeloCRC(cpfMae, cnsCartorio);
		
		if (solicitacaoPreRegistro == null || (!solicitacaoPreRegistro.getSituacaoSolicitacao().equals("2"))) {
			return null;
		}
		
		validaCPF(cpfMae);

		XStream xml = new XStream();
		PreRegistroSolicitacao sol = new PreRegistroSolicitacao();
		xml.alias("sol", PreRegistroSolicitacao.class);
		xml.aliasField("cr", DadosCriancaXml.class, "cr2");

		setaDadosXmlUnidadeInterligada(sol, solicitacaoPreRegistro);
		setaDadosCrianca(sol, solicitacaoPreRegistro);
		sol.setDadosPaiXml(setaDadosPai(solicitacaoPreRegistro));
		sol.setDadosMaeXml(setaDadosMae(solicitacaoPreRegistro));
		sol.setDadosDeclaranteXml(setaDadosDeclarante(solicitacaoPreRegistro));
		sol.setDadosContatoXml(setaDadosContatoXml(solicitacaoPreRegistro));

		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" + xml.toXML(sol);
	}

	private void validaCPF(String cpfMae) throws ApiException {
		if (cpfMae.length() < 11) {
			throw new ApiException("CPF inválido");
		}
	}

	private void setaDadosXmlUnidadeInterligada(PreRegistroSolicitacao sol, PreRegistro solicitacaoPreRegistro) {
		sol.setcodigoSolicitacao(solicitacaoPreRegistro.getNumeroSolicitacao());
		sol.setH(solicitacaoPreRegistro.getCodigoHash());
		sol.setUim((solicitacaoPreRegistro.getMunicipioUi()));
		sol.setUiu(solicitacaoPreRegistro.getUfUi());
		sol.setUiN(solicitacaoPreRegistro.getNomeUi());
		sol.setUiB(solicitacaoPreRegistro.getBairroUi());
		sol.setUiL(solicitacaoPreRegistro.getLogradouroUi());
		sol.setCoCd(solicitacaoPreRegistro.getCodigoUi());
		sol.setCrQ(solicitacaoPreRegistro.getQuantidadeCriancas());
		sol.setpaDe(solicitacaoPreRegistro.getStatusPai());
		sol.setde(solicitacaoPreRegistro.getTipoDeclarante());
		
		sol.converteTipoDeclarante();
	}

	private void setaDadosCrianca(PreRegistroSolicitacao sol, PreRegistro solicitacaoPreRegistro) {
		
		sol.setDadosCrianca1Xml(setaDadosCrianca1(solicitacaoPreRegistro));
		
		if (Integer.parseInt(solicitacaoPreRegistro.getQuantidadeCriancas()) > 1) {
			sol.setDadosCrianca2Xml(setaDadosCrianca2(solicitacaoPreRegistro));
		}
		if (Integer.parseInt(solicitacaoPreRegistro.getQuantidadeCriancas()) > 2) {
			sol.setDadosCrianca3Xml(setaDadosCrianca3(solicitacaoPreRegistro));
		}
		if (Integer.parseInt(solicitacaoPreRegistro.getQuantidadeCriancas()) > 3) {
			sol.setDadosCrianca4Xml(setaDadosCrianca4(solicitacaoPreRegistro));
		}
		if (Integer.parseInt(solicitacaoPreRegistro.getQuantidadeCriancas()) > 4) {
			sol.setDadosCrianca5Xml(setaDadosCrianca5(solicitacaoPreRegistro));
		}
	}
	
	private DadosCriancaXml setaDadosCrianca1(PreRegistro solicitacaoPreRegistro) {
		DadosCriancaXml dadosCriancaXml = new DadosCriancaXml();

		dadosCriancaXml.setCrN(solicitacaoPreRegistro.getNomeCrianca1());
		dadosCriancaXml.setCrS(solicitacaoPreRegistro.getSexoCrianca1());
		dadosCriancaXml.setCrDt(solicitacaoPreRegistro.getDataNascimentoCrianca1().toString());
		dadosCriancaXml.setCrH(solicitacaoPreRegistro.getHoraNascimentoCrianca1());
		dadosCriancaXml.setCrDNV(solicitacaoPreRegistro.getDnvCrianca1());
		dadosCriancaXml.setCrNatUF(solicitacaoPreRegistro.getNaturalidadeUf());
		dadosCriancaXml.setCrNatMun(solicitacaoPreRegistro.getNaturalidade());

		return dadosCriancaXml;
	}
	
	private DadosCriancaXml setaDadosCrianca2(PreRegistro solicitacaoPreRegistro) {
		DadosCriancaXml dadosCriancaXml = new DadosCriancaXml();

		dadosCriancaXml.setCrN(solicitacaoPreRegistro.getNomeCrianca2());
		dadosCriancaXml.setCrS(solicitacaoPreRegistro.getSexoCrianca2());
		dadosCriancaXml.setCrDt(solicitacaoPreRegistro.getDataNascimentoCrianca2().toString());
		dadosCriancaXml.setCrH(solicitacaoPreRegistro.getHoraNascimentoCrianca2());
		dadosCriancaXml.setCrDNV(solicitacaoPreRegistro.getDnvCrianca2());
		dadosCriancaXml.setCrNatUF(solicitacaoPreRegistro.getNaturalidadeUf());
		dadosCriancaXml.setCrNatMun(solicitacaoPreRegistro.getNaturalidade());

		return dadosCriancaXml;
	}
	
	private DadosCriancaXml setaDadosCrianca3(PreRegistro solicitacaoPreRegistro) {
		DadosCriancaXml dadosCriancaXml = new DadosCriancaXml();

		dadosCriancaXml.setCrN(solicitacaoPreRegistro.getNomeCrianca3());
		dadosCriancaXml.setCrS(solicitacaoPreRegistro.getSexoCrianca3());
		dadosCriancaXml.setCrDt(solicitacaoPreRegistro.getDataNascimentoCrianca3().toString());
		dadosCriancaXml.setCrH(solicitacaoPreRegistro.getHoraNascimentoCrianca3());
		dadosCriancaXml.setCrDNV(solicitacaoPreRegistro.getDnvCrianca3());
		dadosCriancaXml.setCrNatUF(solicitacaoPreRegistro.getNaturalidadeUf());
		dadosCriancaXml.setCrNatMun(solicitacaoPreRegistro.getNaturalidade());

		return dadosCriancaXml;
	}
	
	private DadosCriancaXml setaDadosCrianca4(PreRegistro solicitacaoPreRegistro) {
		DadosCriancaXml dadosCriancaXml = new DadosCriancaXml();

		dadosCriancaXml.setCrN(solicitacaoPreRegistro.getNomeCrianca4());
		dadosCriancaXml.setCrS(solicitacaoPreRegistro.getSexoCrianca4());
		dadosCriancaXml.setCrDt(solicitacaoPreRegistro.getDataNascimentoCrianca4().toString());
		dadosCriancaXml.setCrH(solicitacaoPreRegistro.getHoraNascimentoCrianca4());
		dadosCriancaXml.setCrDNV(solicitacaoPreRegistro.getDnvCrianca4());
		dadosCriancaXml.setCrNatUF(solicitacaoPreRegistro.getNaturalidadeUf());
		dadosCriancaXml.setCrNatMun(solicitacaoPreRegistro.getNaturalidade());

		return dadosCriancaXml;
	}
	
	private DadosCriancaXml setaDadosCrianca5(PreRegistro solicitacaoPreRegistro) {
		DadosCriancaXml dadosCriancaXml = new DadosCriancaXml();

		dadosCriancaXml.setCrN(solicitacaoPreRegistro.getNomeCrianca5());
		dadosCriancaXml.setCrS(solicitacaoPreRegistro.getSexoCrianca5());
		dadosCriancaXml.setCrDt(solicitacaoPreRegistro.getDataNascimentoCrianca5().toString());
		dadosCriancaXml.setCrH(solicitacaoPreRegistro.getHoraNascimentoCrianca5());
		dadosCriancaXml.setCrDNV(solicitacaoPreRegistro.getDnvCrianca5());
		dadosCriancaXml.setCrNatUF(solicitacaoPreRegistro.getNaturalidadeUf());
		dadosCriancaXml.setCrNatMun(solicitacaoPreRegistro.getNaturalidade());

		return dadosCriancaXml;
	}

	private DadosPaiXml setaDadosPai(PreRegistro solicitacaoPreRegistro) {

		// Verificando xml's gerados pelo WebRecivil identifiquei que as tags PaEc e
		// PaCep não é preenchida.

		DadosPaiXml dadosPaiXml = new DadosPaiXml();

		dadosPaiXml.setPaN(solicitacaoPreRegistro.getNomePai());
		dadosPaiXml.setPaCPF(solicitacaoPreRegistro.getCpfPai());
		dadosPaiXml.setPaI(solicitacaoPreRegistro.pegaIdadePai());
		dadosPaiXml.setPaNU(solicitacaoPreRegistro.getNaturalidadeUfPai());
		dadosPaiXml.setPaNM(solicitacaoPreRegistro.getNaturalidadePai());
		dadosPaiXml.setPaND(solicitacaoPreRegistro.getNaturalidadeDistritoPai());
		dadosPaiXml.setPaNC(solicitacaoPreRegistro.getNacionalidadePai());
		dadosPaiXml.setPaU(solicitacaoPreRegistro.getResidenciaUfPai());
		dadosPaiXml.setPaM(solicitacaoPreRegistro.getResidenciaMunicipioPai());
		dadosPaiXml.setPaD(solicitacaoPreRegistro.getResidenciaDistritoPai());
		dadosPaiXml.setPaEb(solicitacaoPreRegistro.getResidenciaBairroPai());
		dadosPaiXml.setPaEl(solicitacaoPreRegistro.getResidenciaLogradouroPai());
		dadosPaiXml.setPaEn(solicitacaoPreRegistro.getResidenciaNumeroPai());

		dadosPaiXml.setPaP(solicitacaoPreRegistro.getProfissaoPai());
		dadosPaiXml.setPaDN(solicitacaoPreRegistro.getDataNascimentoPai());
		dadosPaiXml.setPaDI(solicitacaoPreRegistro.getDocumentoPai());
		dadosPaiXml.setPaTDI(solicitacaoPreRegistro.getTipoDocumentoPai());
		dadosPaiXml.setPaPaN(solicitacaoPreRegistro.getFiliacaoPaiPai());
		dadosPaiXml.setPaPaF(solicitacaoPreRegistro.getPaiPaiFalecido());
		dadosPaiXml.setPaMaN(solicitacaoPreRegistro.getFiliacaoMaePai());
		dadosPaiXml.setPaMaF(solicitacaoPreRegistro.getMaePaiFalecida());

		// Verificar se podemos gerar essas tags

		dadosPaiXml.setPaEc("");
		dadosPaiXml.setPaCEP("");

		return dadosPaiXml;
	}

	private DadosMaeXml setaDadosMae(PreRegistro solicitacaoPreRegistro) {
		DadosMaeXml dadosMaeXml = new DadosMaeXml();

		dadosMaeXml.setMaN(solicitacaoPreRegistro.getNomeMae());
		dadosMaeXml.setMaCPF(solicitacaoPreRegistro.getCpfMae());
		dadosMaeXml.setMaI(solicitacaoPreRegistro.getIdadeMae());
		dadosMaeXml.setMaNU(solicitacaoPreRegistro.getNaturalidadeUfMae());
		dadosMaeXml.setMaNM(solicitacaoPreRegistro.getNaturalidadeMae());
		dadosMaeXml.setMaND(solicitacaoPreRegistro.getNaturalidadeDistritoMae());
		dadosMaeXml.setMaNC(solicitacaoPreRegistro.getNacionalidadeMae());
		dadosMaeXml.setMaU(solicitacaoPreRegistro.getResidenciaUfMae());
		dadosMaeXml.setMaM(solicitacaoPreRegistro.getResidenciaMunicipioMae());
		dadosMaeXml.setMaD(solicitacaoPreRegistro.getResidenciaDistritoMae());
		dadosMaeXml.setMaEb(solicitacaoPreRegistro.getResidenciaBairroMae());
		dadosMaeXml.setMaEl(solicitacaoPreRegistro.getResidenciaLogradouroMae());
		dadosMaeXml.setMaEn(solicitacaoPreRegistro.getResidenciaNumeroMae());
		dadosMaeXml.setMaEc(""); // NÃO É GERADO dadosMaeXml.setMaCEP(""); //NÃO É GERADO
		dadosMaeXml.setMaP(solicitacaoPreRegistro.getProfissaoMae());
		dadosMaeXml.setMaDN(solicitacaoPreRegistro.getDataNascimentoMae().toString());
		dadosMaeXml.setMaDI(solicitacaoPreRegistro.getDocumentoMae());
		dadosMaeXml.setMaTDI(solicitacaoPreRegistro.getTipoDocumentoMae());
		dadosMaeXml.setMaPaN(solicitacaoPreRegistro.getFiliacaoPaiMae());
		dadosMaeXml.setMaPaF(solicitacaoPreRegistro.getPaiMaeFalecido());
		dadosMaeXml.setMaMaN(solicitacaoPreRegistro.getFiliacaoMaeMae());
		dadosMaeXml.setMaMaF(solicitacaoPreRegistro.getMaeMaeFalecida());

		return dadosMaeXml;
	}

	private DadosDeclaranteXml setaDadosDeclarante(PreRegistro solicitacaoPreRegistro) {
		DadosDeclaranteXml dadosDeclaranteXml = new DadosDeclaranteXml();

		dadosDeclaranteXml.setDeOP(solicitacaoPreRegistro.getTipoDeclaranteNaSolicitacao());
		dadosDeclaranteXml.setDeT(solicitacaoPreRegistro.getTipoDeclaracao());
		dadosDeclaranteXml.setDeN(solicitacaoPreRegistro.getNomeDeclarante());
		dadosDeclaranteXml.setDeDI(solicitacaoPreRegistro.getDocDeclarante());
		dadosDeclaranteXml.setDeTDI(solicitacaoPreRegistro.getTipoDocDeclarante());
		dadosDeclaranteXml.setDeDN(solicitacaoPreRegistro.getDataNascimentoCriancaDeclarante());
		dadosDeclaranteXml.setDeP(solicitacaoPreRegistro.getProfissaoDeclarante());
		dadosDeclaranteXml.setDeNc(solicitacaoPreRegistro.getNacionalidadeDeclarante());
		dadosDeclaranteXml.setDeU(solicitacaoPreRegistro.getUfResidenciaDeclarante());
		dadosDeclaranteXml.setDeM(solicitacaoPreRegistro.getMunicipioResidenciaDeclarante());
		dadosDeclaranteXml.setDeEb(solicitacaoPreRegistro.getBairroResidenciaDeclarante());
		dadosDeclaranteXml.setDeEl(solicitacaoPreRegistro.getLogradouroResidenciaDeclarante());
		dadosDeclaranteXml.setDeEn(solicitacaoPreRegistro.getNumeroResidenciaDeclarante());
		dadosDeclaranteXml.setDeEc(solicitacaoPreRegistro.getComplementoResidenciaDeclarante());
		dadosDeclaranteXml.setDeDPO(solicitacaoPreRegistro.getDadosProcesso());
		dadosDeclaranteXml.setDeDPA(solicitacaoPreRegistro.getDadosProcuracao());
		
		dadosDeclaranteXml.converteTipoDeclaracao();

		return dadosDeclaranteXml;
	}

	private DadosContatoXml setaDadosContatoXml(PreRegistro solicitacaoPreRegistro) {
		DadosContatoXml dadosContatoXml = new DadosContatoXml();

		dadosContatoXml.setCoN(solicitacaoPreRegistro.getNomeContato());
		dadosContatoXml.setCoT(solicitacaoPreRegistro.getTelFixoContato());
		dadosContatoXml.setCoC(solicitacaoPreRegistro.getTelCelularContato());
		dadosContatoXml.setCoE(solicitacaoPreRegistro.getDadosQuartoHospedagemMae());

		return dadosContatoXml;
	}

	private PreRegistro retornaDadosDaSolicitacaoPreRegistro(String request) {
		try {
			if (verificaParametroPreRegistro()) {
				return preRegistroRepository.buscaPreRegistroCpfMae(getCpfMae(request));
			}
			else return preRegistroRepository.buscaPreRegistro(getCpfMae(request),getCnsCartorio(request));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//TODO: Método alternativo para recuperar o Pré-Registro, pois o Cartosoft consegue enviar apenas um parâmetro
	private PreRegistro recuperaPreRegistroSolicitadoPeloCRC(String cpfMae, String cnsCartorio) {
		try {
			if (verificaParametroPreRegistro()) {
				return preRegistroRepository.buscaPreRegistroCpfMae(cpfMae);
			}
			else return preRegistroRepository.buscaPreRegistro(cpfMae,cnsCartorio);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private boolean verificaParametroPreRegistro() {
		return parametroRepository.retornaValorParametroPreRegistro(Parametro.CNS_CARTORIO_PREREGISTRO);
	}
	
	/*private int retornaQuantidadeCriancas(PreRegistro preRegistro) {
		if (preRegistro.getQuantidadeCriancas() == null) {
			return "0";
		}
		switch (preRegistro.getQuantidadeCriancas()) {
		case "Não":
			return "1";
			
		case "Gêmeos":
			return "2";
			
		case "Trigêmeos":
			return "3";
			
		case "Quadrigêmeos":
			return "4";
			
		case "Quíntuplos":
			return "5";
		}
	}*/
	
	private String getCpfMae(String cpfMae) {
		return cpfMae = cpfMae.split(";")[1];
	}
	private String getCnsCartorio(String cpfMae) {
		return cpfMae = cpfMae.split(";")[0];
	}
}
