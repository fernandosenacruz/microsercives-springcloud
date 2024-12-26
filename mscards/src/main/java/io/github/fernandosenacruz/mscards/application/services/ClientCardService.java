package io.github.fernandosenacruz.mscards.application.services;
import io.github.fernandosenacruz.mscards.domain.ClientCard;
import io.github.fernandosenacruz.mscards.infra.repository.ClientCardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {
    private final ClientCardRepository repository;

    public List<ClientCard> getCardsByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
