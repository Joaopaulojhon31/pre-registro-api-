package com.webrecivil.api.entidade;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "xml_preregistro", schema = "ecivil")
@SequenceGenerator(name = "seq_id_xml", sequenceName = "seq_id_xml", schema = "ecivil", allocationSize = 1)
@Data
public class PreRegistroXML {
	
	@Column(name = "xml")
	private String xml;
	
	@Id
	@Column(name = "id_pre_registro")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_xml")
	private Long idPreRegistro;
	
	@Column(name = "data_inicio")
	private Date dataInicio;
	
	@Column(name = "data_alteracao")
	private Date dataAlteracao;
	
	@Column(name = "data_fim")
	private Date dataFim;
	
	@Column(name = "corregedoria")
	private String corredoria;
	
	@Column(name = "id_unidade_interligada")
	private Long idUnidadeInterligada;
}
