package org.sid.ebankbankaccountservice.repositories;

import org.sid.ebankbankaccountservice.entities.BankAccount;
import org.sid.ebankbankaccountservice.entities.Customer;
import org.sid.ebankbankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
