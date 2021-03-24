package com.webrecivil.api.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webrecivil.api.entidade.HistoricoPreRegistro;
import com.webrecivil.api.entidade.PreRegistro;
import com.webrecivil.api.entidade.PreRegistroXML;
import com.webrecivil.api.entidade.SituacaoPreRegistro;
import com.webrecivil.api.repository.HistoricoPreRegistroRepositoy;
import com.webrecivil.api.repository.PreRegistroRepository;
import com.webrecivil.api.repository.PreRegistroXMLRepository;

@Service
public class SalvarXMLService {

	@Autowired
	private PreRegistroXMLRepository preRegistroXMLRepository;
	@Autowired
	private PreRegistroRepository preRegistroRepository;
	@Autowired
	private HistoricoPreRegistroRepositoy historicoPreRegistroRepositoy;

	public PreRegistroXML inserirXML(String xml) throws Exception {
		try {
			PreRegistro preRegistro = preRegistroRepository.buscaPeloNumeroSolicitacao(pegarCodigoSolicitacaoXml(xml));
			
			if (preRegistro == null || (!preRegistro.getSituacaoSolicitacao().equals(SituacaoPreRegistro.EM_ANDAMENTO))) {
				return null;
			}
			
			PreRegistroXML preRegistroXML = setaDadosPreRegistroXml(preRegistro, xml);
			salvarNoBanco(preRegistroXML);
			atualizaSituacaoSolicitacao(preRegistro.getNumeroSolicitacao());
			setaHistoricoPreRegistro(preRegistro);
			return preRegistroXML;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Não foi possível salvar o XML");
		}
	}
	
	private PreRegistroXML setaDadosPreRegistroXml (PreRegistro preRegistro, String xml) {
		PreRegistroXML preRegistroXML = new PreRegistroXML();
		Date data = new Date(System.currentTimeMillis());
		
		preRegistroXML.setIdPreRegistro(preRegistro.getId());
		preRegistroXML.setXml(xml);
		preRegistroXML.setDataInicio(data);
		preRegistroXML.setDataAlteracao(data);
		preRegistroXML.setCorredoria(preRegistro.getCodCorregedoriaCartorio());
		preRegistroXML.setIdUnidadeInterligada(preRegistro.getCodigoUi());
		return preRegistroXML;
	}
	
	private void atualizaSituacaoSolicitacao(String numeroSolicitacao) {
		try {
			PreRegistro preRegistro = preRegistroRepository.buscaPeloNumeroSolicitacao(numeroSolicitacao);
			preRegistro.setSituacaoSolicitacao(SituacaoPreRegistro.REALIZADO);
			preRegistroRepository.save(preRegistro);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private PreRegistroXML salvarNoBanco(PreRegistroXML xml) {
		return preRegistroXMLRepository.save(xml);
	}

	private String pegarCodigoSolicitacaoXml(String xml) throws Exception {
		xml = xml.replaceAll("<cod_solicitacao>", "idSolicitacao");
		xml = xml.replaceAll("</cod_solicitacao>", "idSolicitacao");
		return xml.split("idSolicitacao")[1];
	}
	
	public void setaHistoricoPreRegistro(PreRegistro preRegistro) {
		montaNovoObjetoHistoricoPreRegistro(preRegistro);
	}

	private HistoricoPreRegistro montaNovoObjetoHistoricoPreRegistro(PreRegistro preRegistro) {
		Date data = new Date(System.currentTimeMillis());
		HistoricoPreRegistro historicoPreRegistro = new HistoricoPreRegistro();
		historicoPreRegistro.setDataHoraAlteracao(data);
		historicoPreRegistro.setCnsCartorio(preRegistro.getCnsCartorio());
		historicoPreRegistro.setPreRegistro(preRegistro);
		historicoPreRegistro.setSituacao(preRegistro.getSituacaoSolicitacao());
		historicoPreRegistroRepositoy.save(historicoPreRegistro);
		return historicoPreRegistro;
	}
}
