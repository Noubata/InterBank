package benyandadamson.interbank.dtos.responses;

import benyandadamson.interbank.data.models.AccountStatus;
import benyandadamson.interbank.data.models.AccountType;
import benyandadamson.interbank.data.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountResponse {
    private AccountType accountType;
    private String AccountNumber;
    private String AccountName;
    private AccountStatus accountStatus;

}
