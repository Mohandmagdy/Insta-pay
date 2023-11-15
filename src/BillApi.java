public class BillApi {

    DatabaseService db;
    public BillApi() {
        db = DatabaseService.getInstance();
    }
    public boolean transfer(String senderAccount, Bill bill) {
        db.updateBalance(senderAccount , bill.getAmount());
        return true;
    }
}
