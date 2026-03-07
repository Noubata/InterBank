package benyandadamson.interbank.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nbiss {
    private Bank bank;
    private String serialNumber;
}
