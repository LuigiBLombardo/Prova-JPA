package br.com.ctw.monitoramento_transformadores.repository;

import br.com.ctw.monitoramento_transformadores.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *Essa classe representa a parte do JpaRepository do Tecnico
 **/
public interface TecnicoRepository extends JpaRepository<Tecnico,Long> {
}
