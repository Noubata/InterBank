package benyandadamson.interbank.services;

import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.requests.TransferRequest;
import benyandadamson.interbank.dtos.requests.WithdrawRequest;
import benyandadamson.interbank.dtos.responses.DepositResponse;
import benyandadamson.interbank.dtos.responses.TransferResponse;
import benyandadamson.interbank.dtos.responses.WithdrawResponse;

public class TransactionServiceImplementation implements TransactionService{

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        return null;
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
