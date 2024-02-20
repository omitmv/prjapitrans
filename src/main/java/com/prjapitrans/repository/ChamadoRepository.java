package com.prjapitrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjapitrans.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
