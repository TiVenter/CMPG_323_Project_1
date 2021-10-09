package org.example.repo.persistence;

import org.example.domain.persistance.AccountTransaction;
import org.example.domain.persistance.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "SELECT" +
            " at" +
            " FROM" +
            " AccountTransaction at " +
            " WHERE at.memberId = :memberId ")
    AccountTransaction getAccountTransactionByMemberId(Long memberId);
}
