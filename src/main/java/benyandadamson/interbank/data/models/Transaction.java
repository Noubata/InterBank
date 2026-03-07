package benyandadamson.interbank.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
