public class BillApi extends API{

    BillApi() {
        super("Bill");
    }

    @Override
    public boolean transfer(String senderAccount, String BillID, double amount) {
        return true;
    }
}
