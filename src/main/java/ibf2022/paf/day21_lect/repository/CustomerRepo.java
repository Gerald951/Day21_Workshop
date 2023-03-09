package ibf2022.paf.day21_lect.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.day21_lect.model.Customer;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String findAllSQL = "Select * from customer;";

    public List<Customer> getAllCustomers() {
        final List<Customer> custList = new ArrayList<Customer>();

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQL);

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setDob(rs.getDate("dob"));
            custList.add(customer);
        }

        return Collections.unmodifiableList(custList);
    }
    
}

