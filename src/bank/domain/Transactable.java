package bank.domain;


import bank.util.LogTracker;

public interface Transactable{
    LogTracker deposit(float ammount);
    LogTracker withdraw(float ammount);
    LogTracker transferTo(Account konto,float ammount);
}