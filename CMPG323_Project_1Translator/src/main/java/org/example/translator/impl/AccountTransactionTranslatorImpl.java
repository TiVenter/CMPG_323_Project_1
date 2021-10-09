package org.example.translator.impl;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistance.AccountTransaction;
import org.example.repo.persistence.AccountTransactionRepository;
import org.example.translator.AccountTransactionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    //THrow exceptions according to what went wrong
    @Override
    public List<AccountTransactionDto> getAllAccountTransaction(){
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        try{
            for (AccountTransaction accountTransaction : accountTransactionRepository.findAll()) {
                accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
            }
        } catch (Exception e) {
            //logg our exceptions to check out and investigate
            throw new RuntimeException("Unable to read from DB", e);
        }
        return accountTransactionDtos;
    }

//    @Override
//    public List<AccountTransactionDto> getAllAccountTransaction() {
//        return null;
//    }

    @Override
    public  AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        try {
            AccountTransaction accountTransaction = accountTransactionRepository.save(accountTransactionDto.getAccountTransaction());
            return new AccountTransactionDto(accountTransaction);
        }catch ( Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public  AccountTransactionDto getAccountTransactionByMemberId(Long memberId){
        try {
            AccountTransaction accountTransaction = accountTransactionRepository.getAccountTransactionByMemberId(memberId);
            return new AccountTransactionDto(accountTransaction);
        }catch ( Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public  AccountTransactionDto getAccountTransactionDtoByMemberId(Long memberId){
        try {
            //return accountTransactionRepository.getAccountTransactionDtoByMemberId(Long memberId);
            return null;
        }catch ( Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

}
