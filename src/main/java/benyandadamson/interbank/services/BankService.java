package benyandadamson.interbank.services;

import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.responses.DepositResponse;

public interface BankService {
    DepositResponse deposit(DepositRequest depositRequest);
}
