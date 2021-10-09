package org.example.logic.flow;

import org.example.domain.dto.AccountTypeDto;

import java.util.List;

public interface CreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountType);
}