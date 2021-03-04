package com.webrecivil.api.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Table(name = "parametro", schema = "ecivil")
@SequenceGenerator(name = "seq_id_parametro", sequenceName = "seq_id_parametro", schema = "ecivil", allocationSize = 1)
@Data
public class Parametro {
	
	public static final String CNS_CARTORIO_PREREGISTRO = "CNS_CARTORIO_PREREGISTRO";
	
	@Id
	@Column(name = "id_parametro")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "valor")
	private String valor;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "habilitado")
	private Boolean habilitado;

	@Version
	@Column(name = "versao")
	private Integer versao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}
}
