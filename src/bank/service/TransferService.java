package bank.service;

import bank.domain.Account;
import bank.util.LogTracker;

public final class TransferService {

    private TransferService() {}

    public static LogTracker transfer(Account from, Account to, float amount) {
        if (from == null || to == null) return LogTracker.Error;
        return from.transferTo(to, amount);
    }
}
