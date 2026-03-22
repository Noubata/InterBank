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
    private int bankCode = 123;
    private int serialNumber = 000000235;
    private List<Account> accounts;
}
