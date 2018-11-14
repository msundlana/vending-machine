package fixxit.interview.assignment.domain;

import java.math.BigDecimal;

public enum Coin {
    FIFTYCENTS(new BigDecimal(0.5)),
    ONEEURO(new BigDecimal(1)),
    TWOEURO(new BigDecimal(2));

    private BigDecimal amount;

    Coin(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
