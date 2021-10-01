package application.repositories;

import application.objects.Customer;
import application.objects.Filter;
import application.objects.State;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {

    @Autowired
    Connection conn;

    @SneakyThrows
    @Override
    public List<Customer> getCustomers(Filter filter) {
        String sql = buildSqlQuery(filter);
        ResultSet rs = conn.createStatement().
                executeQuery(sql);
        List<Customer> ret = mapResultSetToCustomerList(rs);
        return ret;
    }

    private String buildSqlQuery(Filter filter)
    {
        String sql = "select * from customer   " +
                "INNER JOIN country on " +
                "customer.phone REGEXP (GETREGEX(country.code))";

        if (filter.getCountry() != null) {
            sql += " and country.code = " + filter.getCountry().getCode();
        }

        if (filter.getState() != null) {
            if (filter.getState().equals(State.VALID))
                sql += " WHERE customer.phone REGEXP country.regex";
            else if (filter.getState().equals(State.NOT_VALID))
                sql += " WHERE customer.phone not REGEXP country.regex";
        }

        return sql;
    }

    private List<Customer> mapResultSetToCustomerList(ResultSet rs) throws SQLException {
        List<Customer> ret = new ArrayList<>();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(Integer.valueOf(rs.getString(1)));
            customer.setName(rs.getString(2));
            customer.setPhone(rs.getString(3));
            ret.add(customer);
        }
        return ret;
    }
}
