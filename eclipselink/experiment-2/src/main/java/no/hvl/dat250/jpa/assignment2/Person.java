package no.hvl.dat250.jpa.assignment2;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "owners")
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CreditCard> myCreditCards = new HashSet<>();

    public String getName() {
        return this.name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<CreditCard> getCreditCards() {
        return myCreditCards;
    }
}
