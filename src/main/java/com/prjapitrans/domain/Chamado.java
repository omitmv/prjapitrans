package com.prjapitrans.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "tbchamado")
public class Chamado {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter
  @Setter
  private Long cdChamado;

  @Getter
  @Setter
  private Long cdSubGrupo;

  @Getter
  @Setter
  private String obs;

  @Getter
  @Setter
  private String dtAbertura;

  @Getter
  @Setter
  private String dtFechamento;

  @Getter
  @Setter
  private String cdUsuarioAbertura;

  @Getter
  @Setter
  private Long cdUsuarioAtendimento;

  @Getter
  @Setter
  private String dtAtendimento;

  @Getter
  @Setter
  private long avaliacao;

  @Getter
  @Setter
  private String dtUltAtualizacao;

  @Getter
  @Setter
  private String dtFechamentoTemporario;

  @Getter
  @Setter
  private String fl_ativo;

}
