package br.com.ctw.monitoramento_transformadores.mapper;

import br.com.ctw.monitoramento_transformadores.dto.TransformadorRequestDTO;
import br.com.ctw.monitoramento_transformadores.entity.Transformador;

public class TransformadorMapper {

    public Transformador toEntity (TransformadorRequestDTO requestDTO){
         return Transformador.builder()
                 .id(requestDTO.id())
                 .numeroSerie(requestDTO.numeroSerie())
                 .modelo(requestDTO.modelo())
                 .build();
    }
}
