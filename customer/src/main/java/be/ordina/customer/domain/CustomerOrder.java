package be.ordina.customer.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;

@Entity
@Table
public class CustomerOrder extends AbstractAggregateRoot<CustomerOrder> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    @NotBlank(message = " Description is required")
    private String description;

    @NotNull(message = "It must be for a customer")
    private Long customerId;

    @NotNull(message = "It can never be free")
    private BigDecimal amount;

    private boolean paid;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
