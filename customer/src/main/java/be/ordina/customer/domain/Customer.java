package be.ordina.customer.domain;

import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table
public class Customer extends AbstractAggregateRoot<Customer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private int amountOfOrders;

    public Customer(final String name) {
        this.name = name;
    }

    public Customer() {
        //
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void addOrder() {
        this.amountOfOrders = amountOfOrders +1;
    }

    public int getAmountOfOrders() {
        return this.amountOfOrders;
    }
}
