package application.repositories;

import application.objects.Customer;
import application.objects.Filter;

import java.util.List;

public interface ICustomerRepository {

    public List<Customer> getCustomers(Filter filter);

}
