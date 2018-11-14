package fixxit.interview.assignment.domain;

import java.math.BigDecimal;

public enum Drink {
    COLA (new BigDecimal(0.50)),
    FANTA (new BigDecimal(1.50)),
    SPRITE (new BigDecimal(1));
    private final BigDecimal price;

    Drink(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
