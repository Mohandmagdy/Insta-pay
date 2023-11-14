import java.util.*;
public class walletPayment extends payment{
    String walletNumber;

    public walletPayment(String walletNumber , double amount){
        this.walletNumber = walletNumber;
        Random random = new Random();
        this.balance = amount;
    }


    public void setWalletNumber(String walletNumber) {
        this.walletNumber = walletNumber;
    }

    public String getWalletNumber() {
        return walletNumber;
    }

    public  void transferToInstaPay(String username){}

    public  void payBill(String bill_ID){

    }

    public  void transfer(payment receiver){
        if (receiver instanceof bankPayment) {
            System.out.println("cannot transfer from Wallet to Bank");
            return;
        }
    }
}
