package ibf2022.paf.day21_lect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.paf.day21_lect.model.Customer;
import ibf2022.paf.day21_lect.repository.CustomerRepo;

@Service
public class CustomerSvc {

    @Autowired
    private CustomerRepo customerRepo;
    
    public List<Customer> retrieveAllCustomer() {
        
        return customerRepo.getAllCustomers();
    }
    
}
