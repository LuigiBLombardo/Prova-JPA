package br.com.ctw.monitoramento_transformadores.repository;

import br.com.ctw.monitoramento_transformadores.entity.LeituraTermica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *Essa classe representa a parte do JpaRepository do LeituraTermica
 **/
public interface LeituraTermicaRepository extends JpaRepository<LeituraTermica,Long> {
}
