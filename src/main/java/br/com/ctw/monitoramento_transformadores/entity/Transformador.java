package br.com.ctw.monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "transformadores",
            joinColumns = @JoinColumn(name = "transformador_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    private Set<Tecnico> tecnicos = new HashSet<>();

    @OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LeituraTermica> leituraTermicas = new HashSet<>();

    @OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlertaTermico> alertaTermicos = new HashSet<>();
}
