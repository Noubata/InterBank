package benyandadamson.interbank.services;

import benyandadamson.interbank.data.models.Account;
import benyandadamson.interbank.data.models.Transaction;
import benyandadamson.interbank.data.models.TransactionStatus;
import benyandadamson.interbank.data.models.TransactionType;
import benyandadamson.interbank.data.repositories.AccountRepository;
import benyandadamson.interbank.data.repositories.TransactionRepository;
import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.requests.TransferRequest;
import benyandadamson.interbank.dtos.requests.WithdrawRequest;
import benyandadamson.interbank.dtos.responses.DepositResponse;
import benyandadamson.interbank.dtos.responses.TransferResponse;
import benyandadamson.interbank.dtos.responses.WithdrawResponse;
import benyandadamson.interbank.exceptions.AccountNumberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionServiceImplementation implements TransactionService{

    @Autowired
    public AccountRepository accountRepository;
    @Autowired
    public TransactionRepository transactionRepository;

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        if (accountRepository.findByAccountNumber(depositRequest.getAccountNumber()).isPresent()){
            Account account = accountRepository.findByAccountNumber(depositRequest.getAccountNumber()).get();
//           implement passwordEncoder to check if password is correct supplied by the user
//            also validate supplied password
            account.setBalance(depositRequest.getAmount());

            Transaction transaction = new Transaction();
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transaction.setTransactionType(TransactionType.DEPOSIT);
            transaction.setCreatedAt(LocalDateTime.now());
            transaction.setDestinationAccount(account);
            transactionRepository.save(transaction);



            String message = "Amount deposited successfully";
            DepositResponse depositResponse = new DepositResponse(account.getAccountNumber(), message);
            return depositResponse;


        }
        else throw new AccountNumberNotFoundException ("Account number not found");
    }

    @Override
    public WithdrawResponse withdraw(WithdrawRequest withdrawRequest) {
        return null;
    }

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) {
        return null;
    }
}
