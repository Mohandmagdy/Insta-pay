public class instPayApi extends API{
    instPayApi() {
        super("instPay");
    }

    @Override
    public boolean transfer(String senderID, String receiverID, double amount) {
        if (senderID.equals( receiverID)){
            return false ;
        }
        if (!db.checkUser(receiverID))
            return false;
        db.updateBalance(senderID, amount);
        db.updateBalance(receiverID, -amount);

        return true;
    }
}
