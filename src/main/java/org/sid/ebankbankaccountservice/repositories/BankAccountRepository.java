package org.sid.ebankbankaccountservice.repositories;

import org.sid.ebankbankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
