package be.ordina.billing.domain;

import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;

@Entity
@Table
public class Bill extends AbstractAggregateRoot<Bill> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    private Long orderId;
    private Long customerId;

    private boolean paid;

    public Bill(final BigDecimal amount, final Long orderId, final Long customerId) {
        this.amount = amount;
        this.orderId = orderId;
        this.customerId = customerId;
        this.paid = false;
    }

    public Bill() {
        //
    }

    public void pay() {
        this.paid = true;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public boolean isPaid() {
        return paid;
    }

    public class BillPaidEvent {
        private Long billId;
        private Long customerId;
        private Long orderId;
        private BigDecimal amountPaid;

        public BillPaidEvent(Long billId, Long customerId, Long orderId, BigDecimal amountPaid) {
            this.billId = billId;
            this.customerId = customerId;
            this.orderId = orderId;
            this.amountPaid = amountPaid;
        }

        public Long getBillId() {
            return billId;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public Long getOrderId() {
            return orderId;
        }

        public BigDecimal getAmountPaid() {
            return amountPaid;
        }
    }

}
