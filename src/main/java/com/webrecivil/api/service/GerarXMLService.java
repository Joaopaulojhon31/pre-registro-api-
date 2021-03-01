package com.webrecivil.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.webrecivil.api.entidade.PreRegistro;
import com.webrecivil.api.exception.ApiException;
import com.webrecivil.api.monta.xml.DadosContatoXml;
import com.webrecivil.api.monta.xml.DadosCriancaXml;
import com.webrecivil.api.monta.xml.DadosDeclaranteXml;
import com.webrecivil.api.monta.xml.DadosMaeXml;
import com.webrecivil.api.monta.xml.DadosPaiXml;
import com.webrecivil.api.monta.xml.PreRegistroSolicitacao;
import com.webrecivil.api.repository.PreRegistroRepository;

@Service
public class GerarXMLService {

	@Autowired
	private PreRegistroRepository preRegistroRepository;

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

		setaDadosXmlUnidadeInterligada(sol, solicitacaoPreRegistro);
		sol.setDadosCriancaXml(setaDadosCrianca(solicitacaoPreRegistro));
		sol.setDadosPaiXml(setaDadosPai(solicitacaoPreRegistro));
		sol.setDadosMaeXml(setaDadosMae(solicitacaoPreRegistro));
		sol.setDadosDeclaranteXml(setaDadosDeclarante(solicitacaoPreRegistro));
		sol.setDadosContatoXml(setaDadosContatoXml(solicitacaoPreRegistro));

		return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + "\n" + xml.toXML(sol);
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
		sol.setCoCd(solicitacaoPreRegistro.getCoCd());
		sol.setCrQ(retornaQuantidadeCriancas(solicitacaoPreRegistro));
		sol.setpaDe(solicitacaoPreRegistro.getStatusPai());
		sol.setde(solicitacaoPreRegistro.getTipoDeclarante());
	}

	private DadosCriancaXml setaDadosCrianca(PreRegistro solicitacaoPreRegistro) {
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

	private DadosPaiXml setaDadosPai(PreRegistro solicitacaoPreRegistro) {

		// Verificando xml's gerados pelo WebRecivil identifiquei que as tags PaEc e
		// PaCep não é preenchida.

		DadosPaiXml dadosPaiXml = new DadosPaiXml();

		dadosPaiXml.setPaN(solicitacaoPreRegistro.getNomePai());
		dadosPaiXml.setPaCPF(solicitacaoPreRegistro.getCpfPai());
		dadosPaiXml.setPaI(solicitacaoPreRegistro.getIdadePai());
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

	private PreRegistro retornaDadosDaSolicitacaoPreRegistro(String cpfMae) {
		/*String cnsCartorio;
		cnsCartorio = cpfMae.split(";")[0];
		cpfMae = cpfMae.split(";")[1];
		return preRegistroRepository.buscaPeloCpfDaMae(cpfMae,cnsCartorio);*/
		return preRegistroRepository.buscaPeloCpfDaMae(cpfMae);
	}
	
	public String retornaQuantidadeCriancas(PreRegistro preRegistro) {
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

		default: return "0";
		}
	}
}
