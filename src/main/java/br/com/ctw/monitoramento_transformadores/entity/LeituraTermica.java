package br.com.ctw.monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Table(name = "tb_leitura_termica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * Essa entity é a representação do ALertaTermico
 *
 * @param id
 * @param tempOleo
 * @param tempEnrolamento
 * @param dataHora
 * @param alertaTermico
 * @param transformador
 * */
public class LeituraTermica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "temp_oleo",
            nullable = false
    )
    private BigDecimal tempOleo;

    @Column(
            name = "temp_enrolamento",
            nullable = false
    )
    private BigDecimal tempEnrolamento;

    @Column(
            name = "data_hora_leitura",
            nullable = false
    )
    private LocalDateTime dataHora;

    @OneToOne(mappedBy = "leitura", cascade = CascadeType.ALL)
    private AlertaTermico alertaTermico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transformador_id", nullable = false)
    private Transformador transformador;
}
