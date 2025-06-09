package br.com.api.emergencias.model;

import br.com.api.emergencias.enums.StatusVeiculo;
import br.com.api.emergencias.enums.TipoAmbulancia;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "t_veiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String identificacao;
    private String renavam;
    private String placa;

    @Enumerated(EnumType.STRING)
    private TipoAmbulancia tipo_ambulancia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVeiculo status = StatusVeiculo.ATIVO;
    @Column(nullable = false)
    private Long quilometragem = 0L;
    private Date ultima_manutencao;
    private Date proxima_manutencao;

    @Column(name = "created_at", updatable = false)
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    private Date updatedAt = new Date();
}
