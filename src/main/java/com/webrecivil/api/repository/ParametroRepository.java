package com.webrecivil.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webrecivil.api.entidade.Parametro;

public interface ParametroRepository extends JpaRepository<Parametro, Long> {
	
	@Query("SELECT a.habilitado FROM Parametro a where a.nome =:nome ")
	boolean retornaValorParametroPreRegistro(@Param ("nome") String nome);
}
