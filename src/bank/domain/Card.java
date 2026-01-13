package bank.domain;
import bank.util.LogTracker;
import bank.util.Logs;

public class Card implements Transactable{
    Account konto;
    float limit_dzienny;
    float wydane_dzisiaj;
    Card(Account konto){
        this.konto = konto;
    }
    @Override
    public LogTracker deposit(float ammount) {
        if(ammount<0){
            Logs.Log(LogTracker.Error+": oczekiwano dodatniej wartości");
            return LogTracker.Error;
        }
        this.konto.saldo+=ammount;
        Logs.Log(LogTracker.Success+": saldo wzrosło ("+ammount+")");
        return LogTracker.Success;
    }

    @Override
    public LogTracker withdraw(float ammount) {
        if(ammount<0){
            Logs.Log(LogTracker.Error+": oczekiwano dodatniej wartości");
            return LogTracker.Error;
        }
        if(ammount>limit_dzienny){
            Logs.Log(LogTracker.Error+": wartość przekracza limit dzienny");
            return LogTracker.Error;
        }
        if(this.konto.saldo<ammount){
            Logs.Log(LogTracker.Error+": zbyt mało środków na koncie");
            return LogTracker.Error;
        }
        this.konto.saldo-=ammount;
        this.wydane_dzisiaj+=ammount;
        Logs.Log(LogTracker.Success+": saldo zmalało ("+ammount+")");
        return LogTracker.Success;
    }

    @Override
    public LogTracker transferTo(Account konto, float ammount) {
        if(this.withdraw(ammount)!=LogTracker.Success){
            return LogTracker.Error;
        }
        Logs.Log(LogTracker.Success+": przelew na kwotę ("+ammount+") został wykonany.");
        this.wydane_dzisiaj+=ammount;
        konto.saldo+=ammount;
        return LogTracker.Success;
    }
    public void nastepny_dzien(){
        this.wydane_dzisiaj=0;
    }
}

