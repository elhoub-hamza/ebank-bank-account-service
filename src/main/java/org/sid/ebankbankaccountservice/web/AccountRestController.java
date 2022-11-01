package org.sid.ebankbankaccountservice.web;

import org.sid.ebankbankaccountservice.dto.BankAccountRequestDTO;
import org.sid.ebankbankaccountservice.dto.BankAccountResponseDTO;
import org.sid.ebankbankaccountservice.entities.BankAccount;
import org.sid.ebankbankaccountservice.mappers.AccountMapper;
import org.sid.ebankbankaccountservice.repositories.BankAccountRepository;
import org.sid.ebankbankaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

   private BankAccountRepository bankAccountRepository;
   private AccountService accountService;

   private AccountMapper accountMapper;

   public AccountRestController(BankAccountRepository bankAccountRepository) {
      this.bankAccountRepository = bankAccountRepository;
      this.accountService=accountService;
      this.accountMapper=accountMapper;
   }
   @GetMapping("/bankAccounts")
   public List<BankAccount>bankAccounts(){
      return bankAccountRepository.findAll();
   }
   @GetMapping("/bankAccounts/{id}")
   public BankAccount bankAccounts(@PathVariable String id){
      return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
   }
   @PostMapping("/bankAccounts")
   public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
      return accountService.addAccount(requestDTO);
   }
   @PutMapping("/bankAccounts/{id}")
   public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
      BankAccount account=bankAccountRepository.findById(id).orElseThrow();
      if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
      if (bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
      if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
      if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
      return bankAccountRepository.save(account);
   }
   @DeleteMapping("/bankAccounts/{id}")
   public void deleteAccount(@PathVariable String id){
      bankAccountRepository.deleteById(id);
   }
}
