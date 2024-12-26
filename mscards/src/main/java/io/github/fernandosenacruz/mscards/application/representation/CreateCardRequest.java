package io.github.fernandosenacruz.mscards.application.representation;

import io.github.fernandosenacruz.mscards.domain.Card;
import io.github.fernandosenacruz.mscards.domain.CardBrand;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateCardRequest {
    private String name;
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal limit;

    public Card toModel() {
        return new Card(name, brand, income, limit);
    }
}
