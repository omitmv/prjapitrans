package com.prjapitrans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjapitrans.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

  List<Chamado> getByCdUsuarioAberturaAndFlAtivo(Long cdUsuarioAbertura, String flAtivo);

}
