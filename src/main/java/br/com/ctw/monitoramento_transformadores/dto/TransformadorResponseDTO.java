package br.com.ctw.monitoramento_transformadores.dto;

public record TransformadorResponseDTO(
        Long id,
        String numeroSerie,
        String modelo,
        String subestacao,
        double potenciaKwa,
        double limiteTempOleo,
        double limiteTempEnrol
) {
}
