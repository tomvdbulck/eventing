package be.ordina.customer.service;

import be.ordina.customer.domain.Customer;
import be.ordina.customer.domain.CustomerOrder;
import be.ordina.customer.repository.CustomerRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setupCustomers(){
        customerRepository.save(new Customer("Ordina"));
        customerRepository.save(new Customer("Jos"));
    }

    @TransactionalEventListener
    @Transactional
    void onCompletedOrder(CustomerOrder.OrderCompletedEvent event) {

        Customer customer = customerRepository.findById(event.getCustomerId())
                .orElseThrow(() -> new RuntimeException(" customer not found " + event.getCustomerId()));

        customer.addOrder();
        customer = customerRepository.save(customer);

        customer.getAmountOfOrders();
    }
}
