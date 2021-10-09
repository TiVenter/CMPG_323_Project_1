package org.example.logic.flow;

import org.example.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {
    AccountTransactionDto create(AccountTransactionDto accountTransactionDto);
}
