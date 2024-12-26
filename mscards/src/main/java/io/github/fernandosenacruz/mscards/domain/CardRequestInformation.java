package io.github.fernandosenacruz.mscards.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardRequestInformation {
    private String cardId;
    private String cpf;
    private BigDecimal availableCreditLimit;
}
