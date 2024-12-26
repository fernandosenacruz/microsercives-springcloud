package io.github.fernandosenacruz.mscards.application.representation;

import io.github.fernandosenacruz.mscards.domain.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsByClientResponse {
    private String name;
    private String brand;
    private BigDecimal availableCreditLimit;

    public static CardsByClientResponse fromModel(ClientCard model) {
        return new CardsByClientResponse(
                model.getCard().getName(),
                model.getCard().getBrand().toString(),
                model.getLimit()
        );
    }
}
