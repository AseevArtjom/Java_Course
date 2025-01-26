package contoller;

import model.Customer;
import model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

import java.util.List;

@RestController
//@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            System.out.println("Customer with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }


    @PostMapping(value = "/customers/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @RequestMapping(value = "/{id}/tickets", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTicketsByCustomerId(@PathVariable Integer id) {
        List<Ticket> tickets = customerService.getTicketsByCustomerId(id);
        return tickets != null && !tickets.isEmpty() ? ResponseEntity.ok(tickets) : ResponseEntity.noContent().build();
    }
}
