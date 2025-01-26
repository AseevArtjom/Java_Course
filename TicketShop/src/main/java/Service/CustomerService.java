package service;

import dao.CustomerRepository;
import dao.TicketRepository;
import model.Customer;
import model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Customer getCustomerById(Integer id){
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Ticket> getTicketsByCustomerId(Integer customerId){
        return ticketRepository.findByCustomerId(customerId);
    }
}
