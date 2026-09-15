package br.com.ctw.monitoramento_transformadores.service;

import br.com.ctw.monitoramento_transformadores.dto.TransformadorDetalhadoDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorRequestDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorResponseDTO;
import br.com.ctw.monitoramento_transformadores.entity.Transformador;
import br.com.ctw.monitoramento_transformadores.mapper.TransformadorMapper;
import br.com.ctw.monitoramento_transformadores.repository.TransformadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransformadorService {

    private final TransformadorRepository repository;
    private final TransformadorMapper mapper;

    public TransformadorService(TransformadorRepository repository,TransformadorMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public TransformadorResponseDTO createTransformador(TransformadorRequestDTO requestDTO){

        Transformador entity = mapper.toEntity(requestDTO);
        Transformador transformador = repository.save(entity);

        TransformadorResponseDTO responseDTO = mapper.toResponse(transformador);

        return responseDTO;
    }
    @Transactional
    public List<TransformadorResponseDTO> transformadorList(){

        List<Transformador> transformadors = repository.findAll();

        return mapper.toResponseList(transformadors);
    }

    @Transactional
    public TransformadorDetalhadoDTO findByNumeroSerie(String numeroSerie){

        Transformador entity = repository.findByNumeroSerie(numeroSerie).orElseThrow(() -> new RuntimeException("ERRO - O transformador não foi encontrado"));

        TransformadorDetalhadoDTO detalhadoDTO = mapper.toDetalhadoResponse(entity);

        return detalhadoDTO;
    }
    @Transactional
    public void removeTransformador(String numeroSerie){
        Transformador entity = repository.findByNumeroSerie(numeroSerie).orElseThrow(() -> new RuntimeException("ERRO - O transformador não foi encontrado"));

        repository.delete(entity);
    }
}
