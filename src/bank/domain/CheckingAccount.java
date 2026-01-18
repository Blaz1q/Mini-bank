package bank.domain;

import bank.util.Logs;
import bank.util.LogTracker;

public class CheckingAccount extends Account{
    float oplaty;
    public CheckingAccount(String wlasciciel) {
        super(wlasciciel);
        this.oplaty = 0.01F;
    }

    @Override
    public void nalicz() {
        if (this.saldo >= this.oplaty) {
            this.saldo -= this.oplaty;
            Logs.Log(LogTracker.Info + ": Pobrano opłatę systemową (" + this.oplaty + ") od " + getWlasciciel());
        } else {
            Logs.Log(LogTracker.Error + ": Brak środków na opłatę u " + getWlasciciel());
        }
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

