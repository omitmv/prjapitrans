package com.prjapitrans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjapitrans.domain.Chamado;
import com.prjapitrans.service.ChamadoService;

@RestController
@RequestMapping("/ticket")
public class ChamadoController {

  @Autowired
  private ChamadoService chamadoService;

  @PostMapping("/list")
  public ResponseEntity<List<Chamado>> getAll(@RequestBody Long nCdUsuario) {
    return ResponseEntity.ok(chamadoService.listByCdUsuarioAbertura(nCdUsuario));
  }

}
