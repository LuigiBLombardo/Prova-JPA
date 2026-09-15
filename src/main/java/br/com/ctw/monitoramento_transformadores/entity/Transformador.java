package br.com.ctw.monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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
/**
 * Essa entity é a representação do ALertaTermico
 *
 * @param id
 * @param numeroSerie
 * @param modelo
 * @param subestacao
 * @param potenciaKva
 * @param limiteTempOleo
 * @param limiteTempEnrol
 * @param tecnicos
 * @param leituraTermicas
 * @param alertaTermicos
 * */
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
            name = "subestacao",
            nullable = false
    )
    private String subestacao;
    @Column(
            name = "potencia_kva",
            nullable = false
    )
    private BigDecimal potenciaKva;

    @Column(
            name = "limite_temp_oleo",
            nullable = false
    )
    private BigDecimal limiteTempOleo;

    @Column(
            name = "limite_temp_enrol",
            nullable = false
    )
    private BigDecimal limiteTempEnrol;

    @ManyToMany
    @JoinTable(
            name = "transformador_tecnico",
            joinColumns = @JoinColumn(name = "transformador_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    private Set<Tecnico> tecnicos = new HashSet<>();

    @OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LeituraTermica> leituraTermicas = new HashSet<>();

    @OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlertaTermico> alertaTermicos = new HashSet<>();
}
