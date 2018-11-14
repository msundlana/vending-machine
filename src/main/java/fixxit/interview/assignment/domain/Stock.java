package fixxit.interview.assignment.domain;

public class Stock {
    private Drink drink;
    private int amountOfStock;

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getAmountOfStock() {
        return amountOfStock;
    }

    public void setAmountOfStock(int amountOfStock) {
        this.amountOfStock = amountOfStock;
    }
}
