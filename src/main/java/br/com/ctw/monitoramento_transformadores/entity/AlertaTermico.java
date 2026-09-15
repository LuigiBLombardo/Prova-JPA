package br.com.ctw.monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_alertaTermico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * Essa entity é a representação do ALertaTermico
 *
 * @param id
 * @param transformador
 * @param leitura
 * @param dataAlerta
 * @param tipo
 * @param descricao
 * */
public class AlertaTermico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transformador_id", nullable = false)
    private Transformador transformador;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leitura_id")
    private LeituraTermica leitura;

    @Column(
            name = "data_alerta",
            nullable = false
    )
    private LocalDateTime dataAlerta;

    @Column(
            name = "tipo",
            nullable = false,
            length = 30
    )
    private String tipo;

    @Column(
            name = "descricao",
            nullable = false,
            length = 100
    )
    private String descricao;
}
