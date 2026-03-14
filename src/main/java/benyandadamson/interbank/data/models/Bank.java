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
public class Bank {
    private Long bankId;
    private String bankName;
    private String bankCode;
    private List<Account> accounts;
}
