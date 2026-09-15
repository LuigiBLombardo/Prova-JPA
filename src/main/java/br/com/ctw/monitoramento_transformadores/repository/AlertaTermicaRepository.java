package br.com.ctw.monitoramento_transformadores.repository;

import br.com.ctw.monitoramento_transformadores.entity.AlertaTermico;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *Essa classe representa a parte do JpaRepository do AlertaTermico
 **/
public interface AlertaTermicaRepository extends JpaRepository<AlertaTermico,Long> {
}
