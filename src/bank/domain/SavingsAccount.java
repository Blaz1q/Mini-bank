package bank.domain;

import bank.util.LogTracker;

public class SavingsAccount extends Account{
    private float odsetki;
    public SavingsAccount(String wlasciciel){
        super(wlasciciel);
        this.odsetki = 0.3F;
    }

    @Override
    void nalicz() {
        this.saldo += saldo*odsetki;
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
