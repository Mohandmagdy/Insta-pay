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


}
