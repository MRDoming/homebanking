package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String cardHolder;

    private CardType type;

    private CardColor color;

    private String number;

    private Integer cvv;

    private LocalDate fromDate;

    private LocalDate thruDate;

    /*@ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name= "account_id")
    private Account account;*/

    private String numAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    public Card (){};

    public Card(CardType type, CardColor color, String number, Integer cvv, LocalDate fromDate, LocalDate thruDate, Client cliente, String numAccount) {
        this.cardHolder = cliente.getFirstName() + " " + cliente.getLastName();
        this.type = type;
        this.color = color;
        this.number = number;
        this.cvv = cvv;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
        this.client = cliente;
        this.numAccount = numAccount;
        //this.account = account;
    }

    public long getId() {
        return id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client cliente) {
        this.client = cliente;
    }

    public String getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    /*public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }*/

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardHolder='" + cardHolder + '\'' +
                ", type=" + type +
                ", color=" + color +
                ", number='" + number + '\'' +
                ", cvv=" + cvv +
                ", fromDate=" + fromDate +
                ", thruDate=" + thruDate +
                '}';
    }
}
