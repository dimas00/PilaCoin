package br.ufsm.csi.pilacoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "validacoes_pila") // O nome da tabela no banco de dados
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(alphabetic = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidacaoPilaJson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeValidador;

    @Lob
    private byte[] chavePublicaValidador;

    @Lob
    private byte[] assinaturaPilaCoin;

    @ManyToOne(cascade = CascadeType.ALL) // ou CascadeType.PERSIST
    @JoinColumn(name = "pilacoin_id")
    private PilaCoinJson pilaCoin;

    // Outros campos, métodos e anotações necessários
}
