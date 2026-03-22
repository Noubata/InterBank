package benyandadamson.interbank.dtos.requests;

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
public class CreateAccountRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private String city;
    private String state;
    private String nextOfKinName;
    private String nextOfKinNumber;
    private AccountType accountType;
    private UserType userType;
    private AccountStatus accountStatus;

}
