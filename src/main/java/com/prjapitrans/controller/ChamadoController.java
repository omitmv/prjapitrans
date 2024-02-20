package com.prjapitrans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjapitrans.domain.Chamado;
import com.prjapitrans.service.ChamadoService;

@RestController
@RequestMapping("/ticket")
public class ChamadoController {

  @Autowired
  private ChamadoService chamadoService;

  @GetMapping
  public List<Chamado> getAll() {
    return chamadoService.getAllChamados();
  }

}
