package bank.domain;

import bank.util.CardTypes;

import java.util.ArrayList;

public abstract class Account implements Transactable, Exportable{
    protected int numer_konta;
    protected String wlasciciel;
    protected float saldo;
    protected ArrayList<Card> karty;
    Account(String wlasciciel){
        this.numer_konta = (int) Math.floor(Math.random()*10000);
        this.saldo=0;
        this.wlasciciel = wlasciciel;
        this.karty = new ArrayList<>();
    }
    public void printDane(){
        System.out.println(wlasciciel);
        System.out.println(saldo);
        System.out.println(numer_konta);
        System.out.println(this.getClass().getName());
    }
    public Card getCard(CardTypes typ){
        for(Card card : karty){
            if(card.getClass().getName().equals("bank.domain."+typ)) return card;
        }
        return null;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    public void dodajKarte(Card karta){
        this.karty.add(karta);
    }

    public int getNumer_konta() {
        return numer_konta;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    abstract void nalicz();
}
