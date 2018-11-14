package fixxit.interview.assignment.services;

import fixxit.interview.assignment.domain.Coin;
import fixxit.interview.assignment.domain.Stock;
import fixxit.interview.assignment.domain.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineService {
    public int MAX_STOCK = 10;

    VendingMachine viewVendingMachineOptions();

    Stock getStockById(Integer id);

    void modifyStock(VendingMachine vendingMachine);

}
