package bank.domain;

import bank.util.Logs;
import bank.util.LogTracker;

public class SavingsAccount extends Account{
    private float odsetki;
    public SavingsAccount(String wlasciciel){
        super(wlasciciel);
        this.odsetki = 0.3F;
    }

    @Override
    public void nalicz() {
        float wypracowanyZysk = this.saldo * this.odsetki;
        this.saldo += wypracowanyZysk;
        Logs.Log(LogTracker.Info + ": Naliczono odsetki (" + wypracowanyZysk + ") dla " + getWlasciciel());
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

}
