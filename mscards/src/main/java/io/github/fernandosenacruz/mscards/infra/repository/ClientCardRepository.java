package io.github.fernandosenacruz.mscards.infra.repository;

import io.github.fernandosenacruz.mscards.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
    List<ClientCard> findByCpf(String cpf);
}
