package be.ordina.billing;

import be.ordina.billing.repository.BillingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillingApplication {

	private BillingRepository billingRepository;

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}



}
