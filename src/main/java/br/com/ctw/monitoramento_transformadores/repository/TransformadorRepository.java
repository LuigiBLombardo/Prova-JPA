package br.com.ctw.monitoramento_transformadores.repository;

import br.com.ctw.monitoramento_transformadores.dto.TransformadorResponseDTO;
import br.com.ctw.monitoramento_transformadores.entity.Transformador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *Essa classe representa a parte do JpaRepository do Transformador
 **/
public interface TransformadorRepository extends JpaRepository<Transformador, Long> {
    Optional<Transformador> findByNumeroSerie(String numeroSerie);
}
