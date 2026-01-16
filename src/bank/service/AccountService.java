package bank.service;
import bank.domain.*;
import bank.util.AccountTypes;
import bank.util.CardTypes;
import bank.util.LogTracker;
import bank.util.Logs;

import java.util.ArrayList;
import java.util.HashMap;

public final class AccountService {
    private static HashMap<String, ArrayList<Account>> konta = new HashMap<>();
    private static boolean czyIstniejeWlasciciel(String wlasciciel){
        return !konta.containsKey(wlasciciel);
    }
    public static Account getKonto(String wlasciciel,AccountTypes typ){
        Logs.Log(LogTracker.Info+": Pobieranie konta ("+wlasciciel+")");
        if(czyIstniejeWlasciciel(wlasciciel)){
            Logs.Log(LogTracker.Error+": Nie znaleziono kont");
            return null;
        }
        for(Account konto : konta.get(wlasciciel)){
            //czy to jest ten typ, którego szukamy
            if(konto.getClass().getName().equals("bank.domain."+typ.name())) return konto;
        }
        Logs.Log(LogTracker.Error+": Nie znaleziono konta");
        return null;
    }
    public static void ZalozKarte(Account konto, CardTypes typ){
        if(konto==null){
            return;
        }
        Logs.Log(LogTracker.Info+": Zakladanie karty ("+konto.getWlasciciel()+")");
        Card nowaKarta = null;
        switch (typ){
            case CardTypes.DebitCard:{
                nowaKarta = new DebitCard(konto);
                Logs.Log(LogTracker.Success+": stworzono nową kartę "+typ);
            }
            break;
            case CardTypes.VirtualCard:{
                nowaKarta = new VirtualCard(konto);
                Logs.Log(LogTracker.Success+": stworzono nową kartę "+typ);
            }
            break;
            default:
                Logs.Log(LogTracker.Error+": Nieznany typ karty");
                break;
        }
        if(nowaKarta!=null){
            konto.dodajKarte(nowaKarta);
        }

    }
    public static void kontaWlasciciela(String wlasciciel){
        Logs.Log(LogTracker.Info+": Szukanie konta ("+wlasciciel+")");
        if(!konta.containsKey(wlasciciel)){
            Logs.Log(LogTracker.Error+": Nie znaleziono kont");
            return;
        }

        ArrayList<Account> konta_wlasciciela = konta.get(wlasciciel);
        for(Account konto : konta_wlasciciela){
            konto.printDane();
        }
    }
    public static LogTracker withdraw(Account konto,float ammount) {
        if(konto==null) return LogTracker.Error;
        if(ammount>konto.getSaldo()){
            Logs.Log(LogTracker.Error+" brak wystarczających środków na koncie");
            return LogTracker.Error;
        }
        float saldo = konto.getSaldo();
        konto.setSaldo(saldo-ammount);
        Logs.Log(LogTracker.Success+": wypłacono środki ("+ammount+") z konta");
        return LogTracker.Success;
    }
    public static LogTracker deposit(Account konto,float ammount) {
        if(konto==null) return LogTracker.Error;
        if(ammount<0){
            Logs.Log(LogTracker.Error+": oczekiwano dodatniej wartości");
            return LogTracker.Error;
        }
        float saldo = konto.getSaldo();
        konto.setSaldo(saldo+ammount);
        Logs.Log(LogTracker.Success+": saldo wzrosło ("+ammount+")");
        return LogTracker.Success;
    }
    public static LogTracker ZalozKonto(String Wlasciciel, AccountTypes typ){
        Logs.Log(LogTracker.Info+": Zakladanie konta ("+Wlasciciel+")");
        Account noweKonto = null;
        switch (typ){
            case AccountTypes.CheckingAccount:{
                noweKonto = new CheckingAccount(Wlasciciel);
                Logs.Log(LogTracker.Success+": Stworzono konto "+typ);
            }break;
            case AccountTypes.SavingsAccount:{
                noweKonto = new SavingsAccount(Wlasciciel);
                Logs.Log(LogTracker.Success+": Stworzono konto "+typ);
            }
            break;
            default:
                Logs.Log(LogTracker.Error+": Nieznany typ konta");
                break;
        }
        if(!konta.containsKey(Wlasciciel)&&noweKonto!=null){ // nie jestem taki zły, żeby zbierać dane po nieudanej rejestracji, prawda?
            konta.put(Wlasciciel,new ArrayList<>());
        }
        if(noweKonto!=null){
            konta.get(Wlasciciel).add(noweKonto);
            return LogTracker.Success;
        }
        else{
            return LogTracker.Error;
        }
    }


}