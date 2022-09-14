package no.hvl.dat250.jpa.assignment2;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private Integer limit;
    private  Integer balance;

    @OneToOne()
    private Pincode myPincode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owningBank")
    private Bank owningBank;

    public Integer getNumber() {
        return this.number;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Pincode getPincode() {
        return myPincode;
    }

    public Bank getOwningBank() {
        return owningBank;
    }

    public void setOwningBank(Bank bank){
        this.owningBank = bank;
    }
}
