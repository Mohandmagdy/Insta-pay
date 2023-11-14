import java.util.Random;

public class bankPayment extends payment {


    String accountNumber,phoneNumber;

    public bankPayment(String accountNumber,String phoneNumber , double amount) {
        this.accountNumber = accountNumber;
        this.phoneNumber = phoneNumber;
        this.balance = amount;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public  void transferToInstaPay(String username){}

    public  void payBill(String bill_ID){}

    public  void transfer(payment receiver){}
}
