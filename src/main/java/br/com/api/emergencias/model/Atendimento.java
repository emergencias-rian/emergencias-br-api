package br.com.api.emergencias.model;

import br.com.api.emergencias.enums.LocalAtendimento;
import br.com.api.emergencias.enums.StatusAtendimento;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "t_atendimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String protocolo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Cliente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @ManyToOne(fetch = FetchType.LAZY) //lembrar dps
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    @Column(nullable = false)
    private LocalDateTime dataAtendimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LocalAtendimento local;

    @Column(columnDefinition = "TEXT")
    private String endereco;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String queixaPrincipal;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String, String> sinaisVitais;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String procedimento;

    @Column(length = 255)
    private String destino;

    @Column(precision = 10, scale = 2)
    private BigDecimal valorServico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAtendimento status;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(name = "fatura_id")
    private Long faturaId;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}