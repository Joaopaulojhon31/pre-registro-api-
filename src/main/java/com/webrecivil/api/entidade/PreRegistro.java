package com.webrecivil.api.entidade;
import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.Data;

@Entity
@Table(name = "pre_registro", schema = "public")
@SequenceGenerator(name = "seq_id_na", sequenceName = "seq_id_na", schema = "public", allocationSize = 1)
@Data
public class PreRegistro {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_na")
	private Long id;

	@Column(name = "codigo_hash")
	private String codigoHash; //CÓDIGO HASH
	
	@Column(name = "numeroSolicitacao")
	private String numeroSolicitacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inicio_solicitacao")
	private Date dataInicioSolicitacao; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_fim_solicitacao")
	private Date dataFimSolicitacao;
	
	//DADOS UI
	@Column(name = "muncipio_ui")
	private int municipioUi; //MUNICÍO UNIDADE INTERLIGADA;
	
	@Column(name = "uf_ui")
	private String ufUi; //UF UNIDADE INTERLIGADA;
	
	@Column(name = "nome_ui")
	private String nomeUi; //NOME UNIDADE INTERLIGADA;
	
	@Column(name = "bairro_ui")
	private String bairroUi; //BAIRRO UNIDADE INTERLIGADA;
	
	@Column(name = "endereco_ui")
	private String logradouroUi; //ENDEREÇO UNIDADE INTERLIGADA;
	
	@Column(name = "codigo_ui")
	private Long coCd; //CÓDIGO UNIDADE INTERLIGADA;
	
	
	//DADOS CRIANÇA 1
	@Column(name = "qtd_criancas")
	private String qtdCriancas;
	
	@Column(name = "nome_crianca1")
	private String nomeCrianca1;
	
	@Column(name = "sexo_crianca1")
	private String sexoCrianca1;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_nascimento_crianca1")
	private Date dataNascimentoCrianca1;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_nascimento_crianca1")
	private Date horaNascimentoCrianca1;
	
	@Column(name = "dnv_crianca1")
	private String dnvCrianca1;
	
	@Column(name = "naturalidade_UF")
	private String naturalidadeUf;
	
	@Column(name = "naturalidade")
	private String naturalidade;
	
	
	//DADOS CRIANÇA2
	@Column(name = "nome_crianca2")
	private String nomeCrianca2;
	
	@Column(name = "sexo_crianca2")
	private String sexoCrianca2;
	
	//DADOS CRIANÇA 3
	@Column(name = "nome_crianca3")
	private String nomeCrianca3;
	
	@Column(name = "sexo_crianca3")
	private String sexoCrianca3;
	
	//DADOS CRIANÇA 4
	@Column(name = "nome_crianca4")
	private String nomeCrianca4;
	
	@Column(name = "sexo_crianca4")
	private String sexoCrianca4;
	
	//DADOS CRIANÇA 5
	@Column(name = "nome_crianca5")
	private String nomeCrianca5;
	
	@Column(name = "sexo_crianca5")
	private String sexoCrianca5;
	
	
	
	//DADOS MÃE
	@Column(name = "nome_mae")
	private String nomeMae;
	
	@Column(name = "cpf_mae")
	private String cpfMae;
	
	@Column(name = "idade_mae")
	private int idadeMae;
	
	@Column(name = "natural_uf_mae")
	private String naturalUfMae;
	
	@Column(name = "natural_mae")
	private String naturalMae;
	
	@Column(name = "natural_distrito_mae")
	private String naturalDistritoMae;
	
	@Column(name = "nacionalidade_mae")
	private String nacionalidadeMae;
	
	@Column(name = "res_uf_mae")
	private String residenciaUfMae;
	
	@Column(name = "res_municipio_mae")
	private String residenciaMunicipioMae;
	
	@Column(name = "res_distrito_mae")
	private String residenciaDistritoMae;
	
	@Column(name = "res_bairro_mae")
	private String residenciaBairroMae;
	
	@Column(name = "res_logradouro_mae")
	private String residenciaLogradouroMae;
	
	@Column(name = "res_numero_mae")
	private int residenciaNumeroMae;
	
	@Column(name = "res_complemento_mae")
	private String residenciaComplementoMae;
	
	@Column(name = "res_CEP_mae")
	private String residenciaCEPMae;
	
	@Column(name = "profissao_mae")
	private String profissaoMae;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento_mae")
	private Date dtNascimentoMae;
	
	@Column(name = "documento_mae")
	private String documentoMae;
	
	@Column(name = "tipo_documento_mae")
	private String tipoDocumentoMae;
	
	@Column(name = "filiacao_pai_mae")
	private String filiacaoPaiMae;
	
	@Column(name = "pai_mae_falecido")
	private Boolean paiMaeFalecido;
	
	@Column(name = "filiacao_mae_mae")
	private String filiacaoMaeMae;
	
	@Column(name = "mae_mae_falecida")
	private Boolean maeMaeFalecida;
	
	//DADOS PAI
	@Column(name = "nome_pai")
	private String nomePai;
	
	@Column(name = "cpf_pai")
	private String cpfPai;
	
	@Column(name = "natural_uf_pai")
	private String naturalUfPai;
	
	@Column(name = "natural_pai")
	private String naturalPai;
	
	@Column(name = "natural_distrito_pai")
	private String naturalDistritoPai;
	
	@Column(name = "nacionalidade_pai")
	private String nacionalidadePai;
	
	@Column(name = "res_uf_pai")
	private String residenciaUfPai;
	
	@Column(name = "res_municipio_pai")
	private String residenciaMunicipioPai;
	
	@Column(name = "res_distrito_pai")
	private String residenciaDistritoPai;
	
	@Column(name = "res_bairro_pai")
	private String residenciaBairroPai;
	
	@Column(name = "res_logradouro_pai")
	private String residenciaLogradouroPai;
	
	@Column(name = "res_numero_pai")
	private String residenciaNumeroPai;
	
	@Column(name = "res_complemento_pai")
	private String residenciaComplementoPai;
	
	@Column(name = "res_CEP_pai")
	private String residenciaCEPpai;
	
	@Column(name = "profissao_pai")
	private String profissaoPai;
	
	@Column(name = "dt_nascimento_pai")
	private String dtNascimentoPai;
	
	@Column(name = "documento_pai")
	private String documentoPai;
	
	@Column(name = "tipo_documento_pai")
	private String tipoDocumentoPai;
	
	@Column(name = "filiacao_pai_pai")
	private String filiacaoPaiPai;
	
	@Column(name = "pai_pai_falecido")
	private Boolean paiPaiFalecido;
	
	@Column(name = "filiacao_mae_pai")
	private String filiacaoMaePai;
	
	@Column(name = "mae_pai_falecida")
	private Boolean maePaiFalecida;
	
	@Column(name = "status_pai")
	private String statusPai;
	
	@Column(name = "idade_pai")
	private String idadePai;
	
	
	//DADOS CARTÓRIO
	@Column(name = "opt_registro")
	private String optRegistro;
	
	@Column(name = "serventia")
	private String serventia;
	
	@Column(name = "cns_cartorio")
	private String cnsCartorio;
	
	@Column(name = "cd_corregedoria_cartorio")
	private String codCorregedoriaCartorio;
	
	
	//DADOS DECLARANTE
	@Column(name = "tipo_declarante")
	private String tipoDeclarante;
	
	@Column(name = "tipo_declarante_solicitacao")
	private String tipoDeclaranteNaSolicitacao;
	
	@Column(name = "tipo_declaracao")
	private String tipoDeclaracao;
	
	@Column(name = "nome_declarante")
	private String nomeDeclarante;
	
	@Column(name = "doc_declarante")
	private String docDeclarante;
	
	@Column(name = "tipo_doc_declarante")
	private String tipoDocDeclarante;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento_crianca_declarante")
	private Date dataNascimentoCriancaDeclarante;
	
	@Column(name = "profissao_declarante")
	private String profissaoDeclarante;
	
	@Column(name = "nacionalidade_declarante")
	private String nacionalidadeDeclarante;
	
	@Column(name = "uf_residencia_declarante")
	private String ufResidenciaDeclarante;
	
	@Column(name = "municipio_residencia_declarante")
	private String municipioResidenciaDeclarante;
	
	@Column(name = "bairro_residencia_declarante")
	private String bairroResidenciaDeclarante;
	
	@Column(name = "logradouro_residencia_declarante")
	private String logradouroResidenciaDeclarante;
	
	@Column(name = "numero_residencia_declarante")
	private String numeroResidenciaDeclarante;
	
	@Column(name = "complemento_residencia_declarante")
	private String complementoResidenciaDeclarante;
	
	@Column(name = "dados_processo")
	private String dadosProcesso;
	
	@Column(name = "dados_procuracao")
	private String dadosProcuracao;
	
	//DADOS DO CONTATO
	@Column(name = "nome_contato")
	private String nomeContato;
	
	@Column(name = "tel_fixo_contato")
	private String telFixoContato;
	
	@Column(name = "tel_celular_contato")
	private String telCelularContato;
	
	@Column(name = "dados_quarto_hospedagem_mae")
	private String dadosQuartoHospedagemMae;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pre_registro_xml")
	private PreRegistroXML preRegistroID;

}
