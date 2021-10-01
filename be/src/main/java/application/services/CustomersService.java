package application.services;

import application.objects.Customer;
import application.objects.Filter;
import application.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    @Autowired
    ICustomerRepository customerRepository;

    public List<Customer> listCustomers(Filter filter)
    {
       return customerRepository.getCustomers(filter);
    }
}
