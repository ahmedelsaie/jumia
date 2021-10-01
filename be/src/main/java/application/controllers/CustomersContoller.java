package application.controllers;

import application.objects.Country;
import application.objects.Customer;
import application.objects.State;
import application.objects.Filter;
import application.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersContoller {

    @Autowired
    CustomersService customersService;

    @GetMapping
    public List<Customer> listAllCustomers(@RequestParam(required = false) String country,
                                           @RequestParam(required = false) String state)
            {

        Filter filter = new Filter();

        if (state != null)
            filter.setState(State.valueOf(state));

        if (country != null) {
            Country x = new Country();
            x.setCode(country);
            filter.setCountry(x);
        }

        return customersService.listCustomers(filter);
    }

}
