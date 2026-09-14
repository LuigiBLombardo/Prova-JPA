package br.com.ctw.monitoramento_transformadores.dto;

public record TransformadorRequestDTO(
        Long id,
        String numeroSerie,
        String modelo,
        String subestacao,
        double potenciaKva,
        double limiteTempOleo,
        double limiteTempEnrol
){
}
