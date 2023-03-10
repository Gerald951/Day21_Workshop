package ibf2022.paf.day21_lect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.paf.day21_lect.model.Customer;
import ibf2022.paf.day21_lect.model.Order;
import ibf2022.paf.day21_lect.repository.CustomerRepo;

@Service
public class CustomerSvc {

    @Autowired
    private CustomerRepo customerRepo;
    
    public List<Customer> retrieveAllCustomer() {
        
        return customerRepo.getAllCustomers();
    }

    public List<Customer> retrieveAllCustomerLimitOffset(Integer limit, Integer offset) {
        return customerRepo.getAllCustomersWithLimitOffset(limit, offset);
    }
    
    public Customer retrieveCustomerById(Integer Id) {
        return customerRepo.getCustomerWithId(Id);
    }

    public Optional<List<Order>> retrieveOrderWithId(Integer Id) {
        return customerRepo.getOrderWithId(Id); 
    }
}
