package com.webrecivil.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webrecivil.api.entidade.PreRegistro;

public interface PreRegistroRepository extends JpaRepository<PreRegistro, Long> {
	
	@Query("FROM PreRegistro a where a.id =:x")
	PreRegistro buscaId(@Param("x") Long id);
	
	@Query("FROM PreRegistro b where b.cpfMae = cpfMae")
	PreRegistro buscaPeloCpfDaMae(@Param("cpfMae") String cpfMae);
	//PreRegistro buscaPeloCpfDaMae(@Param("cpfMae") String cpfMae, @Param("cnsCartorio") String cnsCartorio);
	
}
