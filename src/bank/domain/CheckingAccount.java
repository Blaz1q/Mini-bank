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
        this.saldo -= this.oplaty;

        String wiadomosc = ": Pobrano opłatę systemową (" + this.oplaty + ") od " + getWlasciciel();

        if (this.saldo < 0) {
            wiadomosc += " [UWAGA: WYSTĄPIŁO ZADŁUŻENIE: " + this.saldo + "]";
            Logs.Log(LogTracker.Error + wiadomosc);
        } else {
            Logs.Log(LogTracker.Info + wiadomosc);
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

}

