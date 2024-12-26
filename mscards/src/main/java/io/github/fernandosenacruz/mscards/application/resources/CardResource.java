package io.github.fernandosenacruz.mscards.application.resources;

import io.github.fernandosenacruz.mscards.application.representation.CardsByClientResponse;
import io.github.fernandosenacruz.mscards.application.representation.CreateCardRequest;
import io.github.fernandosenacruz.mscards.application.services.CardService;
import io.github.fernandosenacruz.mscards.application.services.ClientCardService;
import io.github.fernandosenacruz.mscards.domain.Card;
import io.github.fernandosenacruz.mscards.domain.ClientCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardResource {
    private final CardService cardService;
    private final ClientCardService clientCardService;

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsByIncome(@RequestParam("income") Long income){
        List<Card> cardList = cardService.getCardsByIncomeLessThanEqual(income);
        return ResponseEntity.ok(cardList);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientResponse>> getCardsByClient(
            @RequestParam("cpf") String cpf
    ){
        List<ClientCard> cardList = clientCardService.getCardsByCpf(cpf);
        List<CardsByClientResponse> resultList = cardList.stream()
                .map(CardsByClientResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }

    @PostMapping
    public ResponseEntity createCard(@RequestBody CreateCardRequest request){
        Card card = request.toModel();
        cardService.saveCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
