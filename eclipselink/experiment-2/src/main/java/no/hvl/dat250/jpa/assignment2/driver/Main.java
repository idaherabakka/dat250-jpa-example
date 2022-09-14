package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // create new person
        em.getTransaction().begin();
        Person person = new Person();
        person.setName("Max Mustermann");

        // create new address
        Set<Address> addresses = new HashSet<>();
        Set<Person> people = new HashSet<>();
        people.add(person);
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        addresses.add(address);
        address.setOwners(people);

        person.setAddresses(addresses);

        Bank bank = new Bank();
        bank.setName("Pengebank");

        //create new credit cards
        Pincode pin = new Pincode();
        pin.setPincode("123");
        pin.setCount(1);

        CreditCard card1 = new CreditCard();
        card1.setNumber(12345);
        card1.setBalance(-5000);
        card1.setLimit(-10000);
        card1.setMyPincode(pin);
        card1.setOwningBank(bank);

        CreditCard card2 = new CreditCard();
        card2.setNumber(123);
        card2.setBalance(1);
        card2.setLimit(2000);
        card2.setOwningBank(bank);
        card2.setMyPincode(pin);



        Set<CreditCard> cards = new HashSet<>();
        cards.add(card1);
        cards.add(card2);
        person.setMyCreditCards(cards);

        //Create new Bank
//        Set<CreditCard> car = new HashSet<>();
//        car.add(card1);
//        car.add(card2);
//        bank.setMyCreditCards(car);
        //bank.setCards(car);

        em.persist(person);
        em.persist(pin);
        em.persist(address);
        em.persist(card1);
        em.persist(card2);
        em.persist(bank);
        em.getTransaction().commit();

        em.close();
    }
}
