package bank.domain;

public class DebitCard extends Card{

    public DebitCard(Account konto) {
        super(konto);
        this.limit_dzienny = 500;
    }
}
