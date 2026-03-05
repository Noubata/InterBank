package benyandadamson.interbank.data.models;

import java.math.BigDecimal;
import java.util.List;

public class Account {
    private Long accountId;
    private User owner;
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private BigDecimal balance;
    private Bank bank;
    private List<Transaction> transactions;
}
