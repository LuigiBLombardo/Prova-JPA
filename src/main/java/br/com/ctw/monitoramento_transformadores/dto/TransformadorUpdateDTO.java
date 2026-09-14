package br.com.ctw.monitoramento_transformadores.dto;

public record TransformadorUpdateDTO(
        String numeroSerie,
        String modelo,
        String subestacao,
        double potenciaKva,
        double limiteTempOleo,
        double limiteTempEnrol
) {
}
