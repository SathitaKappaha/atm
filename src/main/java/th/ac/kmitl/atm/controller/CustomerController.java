package th.ac.kmitl.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import th.ac.kmitl.atm.controller.model.Customer;
import th.ac.kmitl.atm.service.Customerservice;

@Controller
public class CustomerController {

    private Customerservice customerservice;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping ("/customer")
    public String getCustomerPage(Model model) {
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "customer";
    }
    @PostMapping("/customer")
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";
    }





}