package com.webrecivil.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webrecivil.api.entidade.PreRegistro;
import com.webrecivil.api.exception.ApiException;
import com.webrecivil.api.repository.PreRegistroRepository;
import com.webrecivil.api.util.Util;

@Service
public class SalvarPreRegistroService {
	
	@Autowired
	private PreRegistroRepository preRegistroRepository;
	
	public PreRegistro salvarPreRegistro(PreRegistro preRegistro) throws ApiException {
		
		validaPreRegistro(preRegistro);
		preRegistro.setCodigoHash(Util.GerarCodigoHash(preRegistro.getNumeroSolicitacao()+"CRYPTOREC"));
		return preRegistroRepository.save(preRegistro);
	}
	
	private void validaPreRegistro(PreRegistro preRegistro) throws ApiException {
		if(preRegistro.getCpfMae().isEmpty()) {
			throw new ApiException("Erro ao registrar dados");
		}
	}

	public PreRegistro localizarPreRegistro(Long idPreRegistro) {
		  PreRegistro PreCadastro = new PreRegistro();	
		  PreCadastro = preRegistroRepository.buscaId(idPreRegistro);
		 return PreCadastro;
	  }
	
	
	
	
}
