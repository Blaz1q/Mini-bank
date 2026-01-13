package bank.domain;

import bank.util.LogTracker;

public class CheckingAccount extends Account{
    float oplaty;
    public CheckingAccount(String wlasciciel) {
        super(wlasciciel);
        this.oplaty = 0.01F;
    }

    @Override
    void nalicz() {
        System.out.println("Naliczono opłaty");
        this.saldo-=oplaty;
    }

    @Override
    public void export() {

    }

    @Override
    public LogTracker deposit(float ammount) {
        return null;
    }

    @Override
    public LogTracker withdraw(float ammount) {
        return null;
    }

    @Override
    public LogTracker transferTo(Account konto, float ammount) {
        return null;
    }
}

