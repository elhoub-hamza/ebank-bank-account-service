package org.sid.ebankbankaccountservice.service;

import org.sid.ebankbankaccountservice.dto.BankAccountRequestDTO;
import org.sid.ebankbankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
