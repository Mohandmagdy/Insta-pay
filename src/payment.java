public abstract class payment {
    double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void transferToInstaPay(String username);

    public abstract void payBill(String bill_ID);

    public abstract void transfer(payment receiver);

}
