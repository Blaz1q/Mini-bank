package bank.domain;

public class VirtualCard extends Card{

    public VirtualCard(Account konto) {
        super(konto);
        this.limit_dzienny = 1000;
    }
}
