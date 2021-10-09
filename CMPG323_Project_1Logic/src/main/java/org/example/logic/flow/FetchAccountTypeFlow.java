package org.example.logic.flow;

import org.example.domain.dto.AccountTypeDto;
//import org.example.domain.persistance.AccountType;
import java.util.List;

// this class will make sure to answer the one res service call
public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
}
