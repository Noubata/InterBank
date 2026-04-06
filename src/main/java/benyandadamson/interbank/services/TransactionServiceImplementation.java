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
import benyandadamson.interbank.exceptions.WrongPasswordException;
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
        validateAccountNumber(depositRequest.getAccountNumber());
        Account account = accountRepository.findByAccountNumber(depositRequest.getAccountNumber()).get();
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

    @Override
    public WithdrawResponse withdraw(WithdrawRequest withdrawRequest) {
        validateAccountNumber(withdrawRequest.getAccount().getAccountNumber());
        validatePassword(withdrawRequest.getPassword(), withdrawRequest.getAccount().getAccountNumber());
        Account account = accountRepository.findByAccountNumber(withdrawRequest.getAccount().getAccountNumber()).get();
        account.setBalance(account.getBalance().subtract(withdrawRequest.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setDestinationAccount(account);
        transactionRepository.save(transaction);

        String message = "Amount withdrawn successfully";
        return new WithdrawResponse(message);
    }

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) {
        return null;
    }

    private void validateAccountNumber(String accountNumber){
        if (!accountRepository.findByAccountNumber(accountNumber).isPresent()){
            throw new AccountNumberNotFoundException ("Account number not found");
        }
    }
    private void validatePassword(String password, String accountNumber){
        Account account = accountRepository.findByAccountNumber(accountNumber).get();
        if(!account.getPassword().matches(password)){
            throw new WrongPasswordException("Sorry, your password is incorrect");
        }
    }

}
