package org.sid.ebankbankaccountservice;

import lombok.Data;
import org.sid.ebankbankaccountservice.entities.BankAccount;
import org.sid.ebankbankaccountservice.entities.Customer;
import org.sid.ebankbankaccountservice.enums.AccountType;
import org.sid.ebankbankaccountservice.repositories.BankAccountRepository;
import org.sid.ebankbankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankBankAccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EbankBankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return args -> {

			Stream.of("Mohamed","Yaassine","Hanae","Imane").forEach(c->{
				Customer customer=Customer.builder()
					.name(c)
					.build();
					customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i < 10; i++) {
					BankAccount bankAccount=BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.balance(1000+Math.random()*90000)
							.createdAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
				}
			});

		};
	}
}
