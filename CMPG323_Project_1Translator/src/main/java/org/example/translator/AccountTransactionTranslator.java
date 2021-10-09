package org.example.translator;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTransactionTranslator {


        List<AccountTransactionDto> getAllAccountTransaction();

        AccountTransactionDto getAccountTransactionByMemberId(Long memberId);

        AccountTransactionDto create(AccountTransactionDto accountTransactionDto);

        AccountTransactionDto getAccountTransactionDtoByMemberId(Long memberId);



}
