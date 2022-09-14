package no.hvl.dat250.jpa.assignment2;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "owners")
    private Set<Person> owners;

    private String street;

    private Integer number;

    public String getStreet() {
        return this.street;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setOwners(Set<Person> owners){
        this.owners=owners;
    }
    public Set<Person> getOwners() {
        return owners;
    }
}
