public class walletApi extends API{
    walletApi() {
        super("Wallet");
    }

    @Override
    public boolean transfer(String senderAccount, String receiverAccount, double amount) {
        db.updateBalance(senderAccount ,amount);
        return true;
    }
}
