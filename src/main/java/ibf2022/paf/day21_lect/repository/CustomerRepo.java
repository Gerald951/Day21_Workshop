package ibf2022.paf.day21_lect.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.day21_lect.model.Customer;
import ibf2022.paf.day21_lect.model.Order;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String findAllSQL = "Select * from customer;";

    private final String findAllSQLLimitOffSet = "select * from customer limit ? offset ?;";

    private final String findSQLWithId = "select * from customer where id = ?;";

    private final String findOrdersWithId = "select * from orders where customer_id = ?;";
    

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

    public List<Customer> getAllCustomersWithLimitOffset(Integer limit, Integer offset) {
        final List<Customer> custList = new ArrayList<Customer>();

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQLLimitOffSet, limit, offset);

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

    public Customer getCustomerWithId(Integer Id) {
        //need to use BeanPropertyRowMapper to map it over to Customer class
        return jdbcTemplate.queryForObject(findSQLWithId, BeanPropertyRowMapper.newInstance(Customer.class), Id);

    }

    public Optional<List<Order>> getOrderWithId(Integer Id) {
        final List<Order> orderList = new ArrayList<>();

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findOrdersWithId, Id);

        if (!rs.next()) 
            return Optional.empty();
        
        rs.previous();

        while (rs.next()) {
            Order order = new Order();
            order.setEmployeeId(rs.getInt("employee_id"));
            order.setCustomerId(rs.getInt("customer_id"));
            LocalDateTime orderDate = (LocalDateTime) rs.getObject("order_date");
            order.setOrderDate(orderDate);
            LocalDateTime shippedDate= (LocalDateTime) rs.getObject("shipped_date");
            order.setShippedDate(shippedDate);
            order.setShippedId(rs.getInt("shipped_id"));
            orderList.add(order);
        }

        return Optional.of(Collections.unmodifiableList(orderList));
        
    }
    
    
}

