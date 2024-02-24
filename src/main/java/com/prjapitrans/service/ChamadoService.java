package com.prjapitrans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjapitrans.domain.Chamado;
import com.prjapitrans.repository.ChamadoRepository;

@Service
public class ChamadoService {

  @Autowired
  private ChamadoRepository chamadoRepository;

  public List<Chamado> listByCdUsuarioAbertura(int nCdUsuario) {
    return chamadoRepository.findByCdUsuarioAbertura(nCdUsuario);
  }

}
