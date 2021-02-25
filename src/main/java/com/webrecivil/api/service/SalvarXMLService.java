package com.webrecivil.api.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webrecivil.api.entidade.PreRegistroXML;
import com.webrecivil.api.repository.PreRegistroXMLRepository;

@Service
public class SalvarXMLService {

	@Autowired
	private PreRegistroXMLRepository preRegistroXMLRepository;

	public PreRegistroXML inserirXML(String xml) throws Exception {
		try {
			Date data = new Date(System.currentTimeMillis());
			PreRegistroXML preRegistroXML = new PreRegistroXML();
			preRegistroXML.setIdPreRegistro(Long.parseLong(pegarCodigoSolicitacaoXml(xml)));
			preRegistroXML.setXml(xml);
			preRegistroXML.setDataInicio(data);
			preRegistroXML.setDataAlteracao(data);
			salvarNoBanco(preRegistroXML);
			return preRegistroXML;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Não foi possível salvar o XML");
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
