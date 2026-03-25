package benyandadamson.interbank.data.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private String hashedPassword;
    private String phoneNumber;
    private String email;
    private UserType userType;
    private List<Account> accounts;
    
}
