package br.com.ctw.monitoramento_transformadores.controller;

import br.com.ctw.monitoramento_transformadores.dto.TransformadorRequestDTO;
import br.com.ctw.monitoramento_transformadores.dto.TransformadorResponseDTO;
import br.com.ctw.monitoramento_transformadores.service.TransformadorService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/transformador")
public class TransformadorController {

    private final TransformadorService service;

    public TransformadorController(TransformadorService service){
        this.service = service;
    }

    @PostMapping("/api/v1/transformadores")
    public ResponseEntity<TransformadorResponseDTO> createByTransformador (@RequestBody TransformadorRequestDTO requestDTO){
        return null;
    }


}
