public class instPayApi extends API{
    @Override
    public boolean transfer(String senderID, String receiverID, double amount) {
        if (!db.checkUser(receiverID))
            return false;
        db.updateBalance(senderID, amount);
        db.updateBalance(receiverID, -amount);

        return true;
    }
}
