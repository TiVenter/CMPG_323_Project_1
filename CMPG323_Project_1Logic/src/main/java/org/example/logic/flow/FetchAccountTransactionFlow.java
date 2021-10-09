package org.example.logic.flow;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTransactionFlow {
    // the nwe go and create return accountTypeTranslator.getAllAccountTypes();
    List<AccountTransactionDto> getAllAccountTransaction();

    AccountTransactionDto getAccountTransactionByMemberId(Long memberId);

    List<AccountTransactionDto> getAllAccountTransactions();
}
