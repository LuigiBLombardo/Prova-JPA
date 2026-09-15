package br.com.ctw.monitoramento_transformadores.controller;

import br.com.ctw.monitoramento_transformadores.dto.TransformadorDetalhadoDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorRequestDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorResponseDTO;
import br.com.ctw.monitoramento_transformadores.entity.Transformador;
import br.com.ctw.monitoramento_transformadores.service.TransformadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Documentação do Endpoints do Monitoramento de Transformadores",
        description = "Endpoints de cada método existente no sistema"
)
@RestController
@RequestMapping("/api/v1/transformadores")
public class TransformadorController {

    private final TransformadorService service;

    public TransformadorController(TransformadorService service){
        this.service = service;
    }


    @Operation(
            description = "Método para cadastrar Transformadores no sistema",
            summary = "Esse metodo vai cadastrar os transformadores"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Transformador cadastrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Houve um erro ao cadastrar um transformador"
            )
    }
    )
    @PostMapping("/api/v1/transformadores")
    public ResponseEntity<TransformadorResponseDTO> createByTransformador (@RequestBody TransformadorRequestDTO requestDTO){
        return ResponseEntity.ok(service.createTransformador(requestDTO));
    }

    @Operation(
            description = "Método para listar todos os Transformadores no sistema",
            summary = "Esse metodo vai listar todos os transformadores"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Transformadores listados com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Houve um erro ao listar os transformadores"
            )
    }
    )
    @GetMapping("/api/v1/transformadores")
    public ResponseEntity<List<TransformadorResponseDTO>> findAll(){
        return ResponseEntity.ok(service.transformadorList());
    }

    @Operation(
            description = "Método para listar um Transformador pelo seu numero de serie no sistema",
            summary = "Esse metodo vai listar o transformador solicitado"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Transformadores listado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Houve um erro ao listar o transformador desejado"
            )
    }
    )
    @GetMapping("/api/v1/transformadores/{numeroSerie}")
    public ResponseEntity<TransformadorDetalhadoDTO> findByNumeroSerie(@PathVariable String numeroSerie){
        return ResponseEntity.ok(service.findByNumeroSerie(numeroSerie));
    }

    @Operation(
            description = "Método para deletar o Transformador solicitado",
            summary = "Esse metodo vai deletar o transformador solicitado"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Transformadores deletado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Houve um erro ao deletar o transformador"
            )
    }
    )
    @DeleteMapping("/api/v1/transformadores/{numeroSerie}")
    public void removerTransformador(@PathVariable String numeroSerie){
        service.removeTransformador(numeroSerie);
    }

}
