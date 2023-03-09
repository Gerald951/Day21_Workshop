package ibf2022.paf.day21_lect.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.paf.day21_lect.model.Customer;
import ibf2022.paf.day21_lect.service.CustomerSvc;

@RestController
@RequestMapping(path="/api/customers")
public class CustomerController {

        @Autowired
        CustomerSvc customerSvc;

        @GetMapping
        public List<Customer> getAllCustomers() {
            return customerSvc.retrieveAllCustomer();
        }

        @GetMapping("/offset")
        public List<Customer> getAllCustomersLimitOffset(Integer limit, Integer offset) {
            return customerSvc.retrieveAllCustomerLimitOffset(5,0);

        }


    
}
