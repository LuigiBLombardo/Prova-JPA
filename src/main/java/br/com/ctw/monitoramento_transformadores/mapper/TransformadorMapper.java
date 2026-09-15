package br.com.ctw.monitoramento_transformadores.mapper;

import br.com.ctw.monitoramento_transformadores.dto.TransformadorDetalhadoDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorRequestDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorResponseDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorUpdateDTO;
import br.com.ctw.monitoramento_transformadores.entity.Transformador;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TransformadorMapper {

    public Transformador toEntity (TransformadorRequestDTO requestDTO){
         return Transformador.builder()
                 .id(requestDTO.id())
                 .numeroSerie(requestDTO.numeroSerie())
                 .modelo(requestDTO.modelo())
                 .subestacao(requestDTO.subestacao())
                 .potenciaKva(requestDTO.potenciaKva())
                 .limiteTempOleo(requestDTO.limiteTempOleo())
                 .limiteTempEnrol(requestDTO.limiteTempEnrol())
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

    public Transformador toUpadate(TransformadorUpdateDTO updateDTO , Transformador transformador){

        if (updateDTO.limiteTempOleo() != null){
            transformador.setLimiteTempOleo(updateDTO.limiteTempOleo());
        }

        if (updateDTO.limiteTempEnrol() != null){
            transformador.setLimiteTempEnrol(updateDTO.limiteTempEnrol());
        }

        return null;
    }

    public TransformadorDetalhadoDTO toDetalhadoResponse(Transformador transformador){

        return new TransformadorDetalhadoDTO(
                transformador.getId(),
                transformador.getNumeroSerie(),
                transformador.getModelo(),
                transformador.getSubestacao(),
                transformador.getPotenciaKva(),
                transformador.getLimiteTempOleo(),
                transformador.getLimiteTempEnrol(),
                transformador.getTecnicos(),
                transformador.getAlertaTermicos(),
                transformador.getLeituraTermicas()
        );
    }
}
