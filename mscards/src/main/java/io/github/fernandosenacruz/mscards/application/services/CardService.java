package io.github.fernandosenacruz.mscards.application.services;

import io.github.fernandosenacruz.mscards.domain.Card;
import io.github.fernandosenacruz.mscards.infra.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> getCardsByIncomeLessThanEqual(Long income) {
        var incomeBigDecimal = new BigDecimal(income);
        return cardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
