package com.webrecivil.api.entidade;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "arquivoXML", schema = "public")
@SequenceGenerator(name = "seq_id_xml", sequenceName = "seq_id_xml", schema = "public", allocationSize = 1)
@Data
public class PreRegistroXML {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_xml")
	private Long id;
	


	
	@Column(name = "xml")
	private String xml;
	
	@Column(name = "id_pre_registro")
	private Long IDPreRegistro;
	
	@Column(name = "dt_criacao")
	private Date dataCriacao;
	
	@Column(name = "dt_alteracao")
	private Date dataAlteracao;
	
	@Column(name = "dt_arquivamento")
	private Date dataArquivamento;
	
	@Column(name = "corregedoria")
	private String corredoria;
	
	@Column(name = "idui")
	private Long idui;
}
