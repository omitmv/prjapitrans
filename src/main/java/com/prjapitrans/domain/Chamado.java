package com.prjapitrans.domain;

import javax.persistence.Column;
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
  private int cdChamado;

  @Getter
  @Setter
  @Column
  private int cdSubGrupo;

  @Getter
  @Setter
  @Column
  private String obs;

  @Getter
  @Setter
  @Column
  private String dtAbertura;

  @Getter
  @Setter
  @Column
  private String dtFechamento;

  @Getter
  @Setter
  @Column
  private int cdUsuarioAbertura;

  @Getter
  @Setter
  @Column
  private int cdUsuarioAtendimento;

  @Getter
  @Setter
  @Column
  private String dtAtendimento;

  @Getter
  @Setter
  @Column
  private int avaliacao;

  @Getter
  @Setter
  @Column
  private String dtUltAtualizacao;

  @Getter
  @Setter
  @Column
  private String dtFechamentoTemporario;

  @Getter
  @Setter
  @Column
  private String flAtivo;

}
