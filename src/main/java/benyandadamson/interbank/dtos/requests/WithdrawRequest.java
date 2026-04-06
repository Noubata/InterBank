package benyandadamson.interbank.dtos.requests;

import benyandadamson.interbank.data.models.Account;
import benyandadamson.interbank.data.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawRequest {
    private Account account;
    private BigDecimal amount;
    private String password;

}
