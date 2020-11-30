package com.webrecivil.api.monta.xml;

import lombok.Data;

@Data
public class DadosContatoXml {
    
    private String coN = ""; //NOME DO CONTATO
    private String coT = ""; //TELEFONE FIXO DO CONTATO
    private String coC = ""; //TELEFONE CELULAR DO CONTATO
    private String coE = ""; //DADOS DO QUARTO ONDE ESTÁ HOSPEDADA A MÃE
}
