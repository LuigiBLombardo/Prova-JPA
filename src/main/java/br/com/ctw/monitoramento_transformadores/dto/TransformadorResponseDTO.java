package br.com.ctw.monitoramento_transformadores.dto;

import br.com.ctw.monitoramento_transformadores.entity.AlertaTermico;
import br.com.ctw.monitoramento_transformadores.entity.LeituraTermica;
import br.com.ctw.monitoramento_transformadores.entity.Tecnico;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Set;

public record TransformadorResponseDTO(
        Long id,

        @Schema(name = "Numero de Serie do Transformador")
        String numeroSerie,

        @Schema(name = "Modelo do Transformador")
        String modelo,

        @Schema(name = "Subestação do Transformadorr")
        String subestacao,

        @Schema(name = "Potencial em Kva do Transformadorr")
        BigDecimal potenciaKva,

        @Schema(name = "Limite de tempo do oleo do Transformadorr")
        BigDecimal limiteTempOleo,

        @Schema(name = "Limite de tempo do enrolamento do Transformadorr")
        BigDecimal limiteTempEnrol
) {
}
