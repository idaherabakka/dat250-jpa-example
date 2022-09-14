package no.hvl.dat250.jpa.assignment2;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owningBank")
    private Set<CreditCard> myCreditCards = new HashSet<>();


    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Set<CreditCard> getOwnedCards() {
        return myCreditCards;
    }

    public void setCards(Set<CreditCard> cards){
        this.myCreditCards=cards;
    }
}
