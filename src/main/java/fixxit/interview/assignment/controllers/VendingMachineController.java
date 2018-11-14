package fixxit.interview.assignment.controllers;

import fixxit.interview.assignment.domain.VendingMachine;
import fixxit.interview.assignment.services.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class VendingMachineController {

    private VendingMachineService vendingMachineService;

    @Autowired
    public void setVendingMachineService(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    @GetMapping("/vending_machine")
    public String viewVendingMachineOptions(Model model){

        model.addAttribute("vending_machine", vendingMachineService.viewVendingMachineOptions());
       return "vending_machine";
    }

    @PostMapping("/vending_machine")
    public String buyDrinks(@ModelAttribute VendingMachine vendingMachine, Model model ){
        vendingMachineService.modifyStock(vendingMachine);
        model.addAttribute("vending_machine", vendingMachineService.viewVendingMachineOptions());
        return "vending_machine";
    }

}
