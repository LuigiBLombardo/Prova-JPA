package br.com.ctw.monitoramento_transformadores.repository;

import br.com.ctw.monitoramento_transformadores.entity.AlertaTermico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaTermicaRepository extends JpaRepository<AlertaTermico,Long> {
}
