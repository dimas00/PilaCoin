package br.ufsm.csi.pilacoin.repository;

import br.ufsm.csi.pilacoin.model.PilaCoin;
import br.ufsm.csi.pilacoin.model.ValidacaoPilaJson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilaCoinRepository extends JpaRepository<ValidacaoPilaJson, Long> {
    // Se necessário, você pode adicionar métodos de consulta personalizados aqui
}
