package benyandadamson.interbank.services;

import benyandadamson.interbank.data.models.Account;
import benyandadamson.interbank.data.repositories.AccountRepository;
import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.requests.TransferRequest;
import benyandadamson.interbank.dtos.requests.WithdrawRequest;
import benyandadamson.interbank.dtos.responses.DepositResponse;
import benyandadamson.interbank.dtos.responses.TransferResponse;
import benyandadamson.interbank.dtos.responses.WithdrawResponse;
import benyandadamson.interbank.exceptions.AccountNumberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionServiceImplementation implements TransactionService{

    @Autowired
    public AccountRepository accountRepository;

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        if (accountRepository.findByAccountNumber(depositRequest.getAccountNumber()).isPresent()){
            Account account = accountRepository.findByAccountNumber(depositRequest.getAccountNumber()).get();
//           implement passwordEncoder to check if password is correct supplied by the user
//            also validate supplied password
            account.setBalance(depositRequest.getAmount());

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
