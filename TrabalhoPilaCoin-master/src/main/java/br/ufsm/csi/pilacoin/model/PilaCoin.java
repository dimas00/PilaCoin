package br.ufsm.csi.pilacoin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "pilacoins") // O nome da tabela no banco de dados
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class PilaCoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // Para lidar com campos grandes, como byte[]
    private byte[] chaveCriador;

    private String nomeCriador;

    @Temporal(TemporalType.TIMESTAMP) // Indica o tipo de temporalidade do campo
    private Date dataCriacao;

    private String nonce;
}
