package benyandadamson.interbank.data.models;

import java.time.LocalDateTime;

public class Transaction {
    private Long transactionId;
    private String transactionReference;
    private TransactionStatus transactionStatus;
    private TransactionType transactionType;
    private LocalDateTime createdAt;
    private Account sourceAccount;
    private Account destinationAccount;
    private Bank bank;
    private Account account;
}
