package br.com.ctw.monitoramento_transformadores.mapper;

import br.com.ctw.monitoramento_transformadores.dto.TransformadorRequestDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorResponseDTO;
import br.com.ctw.monitoramento_transformadores.entity.Transformador;

import java.util.List;

public class TransformadorMapper {

    public Transformador toEntity (TransformadorRequestDTO requestDTO){
         return Transformador.builder()
                 .id(requestDTO.id())
                 .numeroSerie(requestDTO.numeroSerie())
                 .modelo(requestDTO.modelo())
                 .build();
    }

    public List<TransformadorResponseDTO> toResponseList(List<Transformador> transformadors){
        return transformadors.stream().map(this::toResponse).toList();
    }

    public TransformadorResponseDTO toResponse(Transformador transformador){

        return new TransformadorResponseDTO(
                transformador.getId(),
                transformador.getNumeroSerie(),
                transformador.getModelo(),
                transformador.getSubestacao(),
                transformador.getPotenciaKva(),
                transformador.getLimiteTempOleo(),
                transformador.getLimiteTempEnrol()
        );
    }

}
