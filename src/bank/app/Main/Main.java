package bank.app.Main;

import bank.domain.Account;
import bank.domain.Card;
import bank.service.AccountService;
import bank.util.AccountTypes;
import bank.util.CardTypes;
import bank.util.Logs;
import bank.service.TransferService;

public class Main {
    public static void main(String[] args) {
        AccountService.ZalozKonto("Blazej", AccountTypes.CheckingAccount);
        AccountService.ZalozKonto("Blazej", AccountTypes.SavingsAccount);

        AccountService.kontaWlasciciela("Blazej");

        Account oszczednosciowe = AccountService.getKonto("Blazej", AccountTypes.SavingsAccount);
        Account rozliczeniowe = AccountService.getKonto("Blazej", AccountTypes.CheckingAccount);

        AccountService.deposit(oszczednosciowe, 1000.0f);
        AccountService.deposit(rozliczeniowe, 500.0f);

        AccountService.ZalozKarte(rozliczeniowe, CardTypes.VirtualCard);
        Card vCard = rozliczeniowe.getCard(CardTypes.VirtualCard);
        vCard.withdraw(1200.0f); // Przekraczamy limit dzienny

        TransferService.transfer(rozliczeniowe, oszczednosciowe, 100.0f);

        AccountService.przetworzWszystkieKonta();

        System.out.println("\nLogi:\n");
        Logs logs = new Logs();
        logs.export();
    }
}
