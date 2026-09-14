package br.com.ctw.monitoramento_transformadores.repository;

import br.com.ctw.monitoramento_transformadores.entity.LeituraTermica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeituraTermicaRepository extends JpaRepository<LeituraTermica,Long> {
}
