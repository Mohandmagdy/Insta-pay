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

        Scanner scanner = new Scanner(System.in);

        double amount = super.getAmount() ;
        if ( amount > balance) {
            System.out.println("your balance is not enough to complete the transfer " + amount ) ;
            return;
        }
        if ( amount <= 0) {
            System.out.println("invalid amount to transfer" ) ;
            return;
        }

        System.out.println("Enter the " + myAPI.getName() + " number: ") ;

        String accNumber = scanner.nextLine() ;

        if (!myAPI.transfer(username , accNumber , amount ) )
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
