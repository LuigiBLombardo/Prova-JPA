package br.com.ctw.monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_transformador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transformador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "numero_serie",
            nullable = false,
            unique = true,
            length = 50
    )
    private String numeroSerie;

    @Column(
            name = "modelo",
            nullable = false,
            length = 100
    )
    private String modelo;

    @Column(
            name = "potencia_kwa",
            nullable = false
    )
    private Double potenciaKwa;

    @Column(
            name = "limite_temp_oleo",
            nullable = false
    )
    private Double limiteTempOleo;

    @Column(
            name = "limite_temp_enrol",
            nullable = false
    )
    private Double limiteTempEnrol;
}
