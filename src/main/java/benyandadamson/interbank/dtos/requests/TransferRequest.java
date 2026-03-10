package benyandadamson.interbank.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
    private String sourceAccount;
    private String destinationAccount;
    private double amount;
    private String password;
}
