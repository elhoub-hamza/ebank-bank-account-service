package org.sid.ebankbankaccountservice.mappers;

import org.sid.ebankbankaccountservice.dto.BankAccountRequestDTO;
import org.sid.ebankbankaccountservice.dto.BankAccountResponseDTO;
import org.sid.ebankbankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
