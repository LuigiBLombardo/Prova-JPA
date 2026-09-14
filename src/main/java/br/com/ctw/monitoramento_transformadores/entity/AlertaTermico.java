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
            name = "descrição",
            nullable = false,
            length = 255
    )
    private String descricao;
}
