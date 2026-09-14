package br.com.ctw.monitoramento_transformadores.repository;

import br.com.ctw.monitoramento_transformadores.entity.Transformador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransformadorRepository extends JpaRepository<Transformador, Long> {
}
