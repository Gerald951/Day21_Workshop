package ibf2022.paf.day21_lect.restcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.paf.day21_lect.model.Customer;
import ibf2022.paf.day21_lect.model.Order;
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

        @GetMapping("/limit")
        public List<Customer> getAllCustomersLimitOffset(@RequestParam Integer limit, @RequestParam Integer offset) {
            return customerSvc.retrieveAllCustomerLimitOffset(limit, offset);

        }

        @GetMapping("/{customerId}")
        public Customer getCustomerId(@PathVariable Integer customerId) {
            return customerSvc.retrieveCustomerById(customerId);

        }

        @GetMapping("/{customerId}/orders")
        public List<Order> getOrdersWithCustomerId(@PathVariable Integer customerId) {
            if (!customerSvc.retrieveOrderWithId(customerId).isPresent())
                return null;
            return customerSvc.retrieveOrderWithId(customerId).get();
        }


    
}
