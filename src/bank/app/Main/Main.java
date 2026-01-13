package bank.app.Main;

import bank.domain.Account;
import bank.domain.Card;
import bank.service.AccountService;
import bank.util.AccountTypes;
import bank.util.CardTypes;
import bank.util.Logs;

public class Main {
    public static void main(String[] args) {
        AccountService.ZalozKonto("Blazej", AccountTypes.CheckingAccount);
        AccountService.kontaWlasciciela("Blazej");
        Account kontoBlazej = AccountService.getKonto("Blazej",AccountTypes.SavingsAccount);
        kontoBlazej = AccountService.getKonto("Blazej",AccountTypes.CheckingAccount);
        if(kontoBlazej!=null){
            AccountService.deposit(kontoBlazej,10000);
            AccountService.ZalozKarte(kontoBlazej, CardTypes.VirtualCard);
            Card karta = kontoBlazej.getCard(CardTypes.VirtualCard);
            karta.withdraw(20.0F);
        }
        System.out.println("\nLogi:\n");
        Logs logs = new Logs();
        logs.export();
    }
}
