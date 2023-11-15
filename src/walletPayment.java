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


    @Override
    public void pay(API myAPI , String username){
        double amount = super.getAmount() ;
        if (amount < 0 || amount > balance) {
            System.out.println("your balance is not enough to pay " + amount ) ;
        }

        String accountNumber = super.getAccountNumber() ;
        if (!myAPI.transfer( username , accountNumber , amount ) )
            System.out.println("sorry couldn't complete the transfer");
        else {
            balance -= amount;
            System.out.println("the amount transferred your current balance is " +balance );
        }
    }


}
