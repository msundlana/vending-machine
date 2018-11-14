package fixxit.interview.assignment.domain;

import javax.validation.constraints.NotNull;
import java.util.EnumMap;
import java.util.Map;

public class VendingMachine {

    private Map<Integer, Stock> stocks;
    private EnumMap<Coin, String> coinOption;
    private Map<Integer, Integer> maxStocks;
    private Coin coin;
    private boolean valid = true;

    @NotNull
    private Integer stockId;
    private int quantity;

    public Map<Integer, Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Map<Integer, Stock> stocks) {
        this.stocks = stocks;
    }


    public EnumMap<Coin, String> getCoinOption() {
        return coinOption;
    }

    public void setCoinOption(EnumMap<Coin, String> coinOption) {
        this.coinOption = coinOption;
    }

    public Map<Integer, Integer> getMaxStocks() {
        return maxStocks;
    }

    public void setMaxStocks(Map<Integer, Integer> maxStocks) {
        this.maxStocks = maxStocks;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public Coin getCoin() {
        return coin;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
