package com.webrecivil.api.service;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webrecivil.api.entidade.PreRegistro;
import com.webrecivil.api.entidade.PreRegistroXML;
import com.webrecivil.api.repository.PreRegistroRepository;
import com.webrecivil.api.repository.PreRegistroXMLRepository;

@Service
public class SalvarXMLService {

	@Autowired
	private PreRegistroXMLRepository preRegistroXMLRepository;
	@Autowired
	private PreRegistroRepository preRegistroRepository;
	@PersistenceContext
	private EntityManager entityManager;

	public PreRegistroXML inserirXML(String xml) throws Exception {
		try {
			PreRegistro preRegistro = buscaPreregistroNumeroSolicitacao(pegarCodigoSolicitacaoXml(xml));
			if (preRegistro == null || (!preRegistro.getSituacaoSolicitacao().equals("2"))) {
				return null;
			}
			
			Date data = new Date(System.currentTimeMillis());
			
			PreRegistroXML preRegistroXML = new PreRegistroXML();
			preRegistroXML.setIdPreRegistro(preRegistro.getId());
			preRegistroXML.setXml(xml);
			preRegistroXML.setDataInicio(data);
			preRegistroXML.setDataAlteracao(data);
			preRegistroXML.setCorredoria(preRegistro.getCodCorregedoriaCartorio());
			preRegistroXML.setIdUnidadeInterligada(preRegistro.getCoCd());
			salvarNoBanco(preRegistroXML);
			atualizaSituacaoSolicitacao(preRegistro.getNumeroSolicitacao(),preRegistroXML);
			return preRegistroXML;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Não foi possível salvar o XML");
		}
	}
	
	public void atualizaSituacaoSolicitacao(String numeroSolicitacao, PreRegistroXML preRegistroXML) {
		try {
			Query query = getEntityManager().createQuery("SELECT solicitacao FROM PreRegistro solicitacao WHERE solicitacao.numeroSolicitacao = :numeroSolicitacao");
			query.setParameter("numeroSolicitacao", numeroSolicitacao.toUpperCase().trim());
			PreRegistro preRegistro = (PreRegistro) query.getSingleResult();
			preRegistro.setSituacaoSolicitacao("4");
			preRegistroRepository.save(preRegistro);
			//return preRegistro;
		} catch (Exception e) {
			//return null;
		}
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public PreRegistro buscaPreregistroNumeroSolicitacao(String numeroSolicitacao) {
		try {
			Query query = getEntityManager().createQuery("SELECT solicitacao FROM PreRegistro solicitacao WHERE solicitacao.numeroSolicitacao = :numeroSolicitacao");
			query.setParameter("numeroSolicitacao", numeroSolicitacao.toUpperCase().trim());
			PreRegistro preRegistro = (PreRegistro) query.getSingleResult();
			return preRegistro;
		} catch (Exception e) {
			return null;
		}
	}

	private PreRegistroXML salvarNoBanco(PreRegistroXML xml) {
		return preRegistroXMLRepository.save(xml);
	}

	public String pegarCodigoSolicitacaoXml(String xml) throws Exception {
		xml = xml.replaceAll("<cod_solicitacao>", "idSolicitacao");
		xml = xml.replaceAll("</cod_solicitacao>", "idSolicitacao");
		return xml.split("idSolicitacao")[1];
	}
}
