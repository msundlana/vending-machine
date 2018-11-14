package fixxit.interview.assignment.services;

import fixxit.interview.assignment.domain.Coin;
import fixxit.interview.assignment.domain.Drink;
import fixxit.interview.assignment.domain.Stock;
import fixxit.interview.assignment.domain.VendingMachine;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {

    private VendingMachine vendingMachine;
    private BigDecimal change;

    public VendingMachineServiceImpl() {
        loadVendingMachine();
    }

    @Override
    public VendingMachine viewVendingMachineOptions() {
        return vendingMachine;
    }


    private void loadVendingMachine(){

        vendingMachine = new VendingMachine();
        vendingMachine.setStocks(new HashMap<>());

        Stock colaStock = new Stock();
        colaStock.setDrink(Drink.COLA);
        colaStock.setAmountOfStock(MAX_STOCK);
        vendingMachine.getStocks().put(1,colaStock);

        Stock fantaStock = new Stock();
        fantaStock.setDrink(Drink.FANTA);
        fantaStock.setAmountOfStock(MAX_STOCK);
        vendingMachine.getStocks().put(2,fantaStock);

        Stock spriteStock = new Stock();
        spriteStock.setDrink(Drink.SPRITE);
        spriteStock.setAmountOfStock(MAX_STOCK);
        vendingMachine.getStocks().put(3,spriteStock);

        vendingMachine.setCoinOption(new EnumMap<Coin, String>(Coin.class));

        vendingMachine.getCoinOption().put(Coin.FIFTYCENTS,"50 cents");
        vendingMachine.getCoinOption().put(Coin.ONEEURO,"1 euro");
        vendingMachine.getCoinOption().put(Coin.TWOEURO,"2 euro");

        vendingMachine.setMaxStocks(new HashMap<>());

        vendingMachine.getMaxStocks().put(1,MAX_STOCK);
        vendingMachine.getMaxStocks().put(2,MAX_STOCK);
        vendingMachine.getMaxStocks().put(3,MAX_STOCK);

    }

    @Override
    public Stock getStockById(Integer id) {
        return vendingMachine.getStocks().get(id);
    }

    @Override
    public void modifyStock(VendingMachine vendingMachine) {
        Stock stock = this.vendingMachine.getStocks().get(vendingMachine.getStockId());
        this.vendingMachine.setStockId(vendingMachine.getStockId());
        double price = vendingMachine.getQuantity()>0?stock.getDrink().getPrice().doubleValue()*vendingMachine.getQuantity():stock.getDrink().getPrice().doubleValue();
        if(vendingMachine.getCoin().getAmount().doubleValue()>=price){
            stock.setAmountOfStock(stock.getAmountOfStock() - vendingMachine.getQuantity());
            this.vendingMachine.getMaxStocks().put(vendingMachine.getStockId(),stock.getAmountOfStock());
            this.change = new BigDecimal(vendingMachine.getCoin().getAmount().doubleValue() - price);
            if(change.doubleValue() == Coin.FIFTYCENTS.getAmount().doubleValue()){
                this.vendingMachine.setCoin(Coin.FIFTYCENTS);
            }else if(change.doubleValue() == Coin.ONEEURO.getAmount().doubleValue()){
                this.vendingMachine.setCoin(Coin.ONEEURO);
            }else if(change.doubleValue() == Coin.TWOEURO.getAmount().doubleValue()){
                this.vendingMachine.setCoin(Coin.TWOEURO);
            }else {
                this.vendingMachine.setCoin(null);
            }
        }else {
            this.change = null;
            this.vendingMachine.setCoin(null);
        }
        this.checkAmount(this.vendingMachine.getCoin());
    }


    private void checkAmount(Coin coin) {
        this.vendingMachine.setValid(coin==null && this.change==null?false:true);
    }

}
