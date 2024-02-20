package com.prjapitrans.domain.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class tbctrusuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter
  @Setter
  private Long cdUsuario;

  @Getter
  @Setter
  @Column
  private String login;

  @Getter
  @Setter
  @Column
  private Long cdFuncionario;

  @Getter
  @Setter
  @Column
  private Long cdCliente;

  @Getter
  @Setter
  @Column
  private String senha;

  @Getter
  @Setter
  @Column
  private String flAtivo;

  @Getter
  @Setter
  @Column
  private String flAdmin;

  @Getter
  @Setter
  @Column
  private String email;

  @Getter
  @Setter
  @Column
  private Long codintfunc;

  @Getter
  @Setter
  @Column
  private String flAtendente;

  @Getter
  @Setter
  @Column
  private String senhaDelphi;

  @Getter
  @Setter
  @Column
  private String senhaEmail;

  @Getter
  @Setter
  @Column
  private String dtCadastro;

  @Getter
  @Setter
  @Column
  private String nome;

  @Getter
  @Setter
  @Column
  private String dtNascimento;

  @Getter
  @Setter
  @Column
  private String loginSascar;

  @Getter
  @Setter
  @Column
  private String ultSession;

}
