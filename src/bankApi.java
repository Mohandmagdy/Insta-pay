public class bankApi extends API {


    bankApi() {
        super("Bank");
    }

    @Override
    public  boolean transfer(String senderAccount, String receiverAccount, double amount) {
        db.updateBalance(senderAccount , amount);
        return true;
    }
}
