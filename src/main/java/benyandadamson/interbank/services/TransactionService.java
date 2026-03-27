package benyandadamson.interbank.services;

import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.requests.TransferRequest;
import benyandadamson.interbank.dtos.requests.WithdrawRequest;
import benyandadamson.interbank.dtos.responses.DepositResponse;
import benyandadamson.interbank.dtos.responses.TransferResponse;
import benyandadamson.interbank.dtos.responses.WithdrawResponse;

public interface TransactionService {
    DepositResponse deposit(DepositRequest depositRequest);
    WithdrawResponse withdraw(WithdrawRequest withdrawRequest);
    TransferResponse transfer(TransferRequest transferRequest);
}
