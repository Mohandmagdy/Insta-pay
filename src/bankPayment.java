import java.util.Random;
import java.util.Scanner;

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



    public void pay(API myAPI , String username ){
        double amount = super.getAmount() ;
        if (amount < 0 || amount > balance) {
            System.out.println("your balance is not enough to pay " + amount ) ;

        }

        String accountNumber = super.getAccountNumber() ;
        if (!myAPI.transfer(username , accountNumber , amount ) )
            System.out.println("sorry couldn't complete the transfer");
        else {
            balance -= amount;
            System.out.println("the amount transferred your current balance is " +balance );
        }
    }


//    public boolean payBill() {
//        System.out.println("Enter the amount you want to pay" );
//        return true;
//    }

}
