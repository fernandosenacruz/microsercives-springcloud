package io.github.fernandosenacruz.mscards.infra.mqueue;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.fernandosenacruz.mscards.domain.Card;
import io.github.fernandosenacruz.mscards.domain.CardRequestInformation;
import io.github.fernandosenacruz.mscards.domain.ClientCard;
import io.github.fernandosenacruz.mscards.infra.repository.CardRepository;
import io.github.fernandosenacruz.mscards.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CardIssuanceSubscriber {
    private final CardRepository cardRepository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void receive(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();

            CardRequestInformation info = mapper.readValue(payload, CardRequestInformation.class);
            Card card = cardRepository.findById(Long.valueOf(info.getCardId())).orElseThrow();

            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCpf(info.getCpf());
            clientCard.setLimit(info.getAvailableCreditLimit());

            clientCardRepository.save(clientCard);
        } catch (Exception e) {
            log.error("Error to receive card issuance: {}", e.getMessage());
        }
    }
}
