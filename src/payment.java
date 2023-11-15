import java.util.Scanner;

public abstract class payment {
    double balance;
    Scanner scanner = new Scanner(System.in);
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void pay(API myAPI , String username) ;

    protected double getAmount(){

        System.out.println("Enter the amount you want to transfer or pay" );
        double amount = scanner.nextDouble() ;
        return amount ;
    }

    public void payBill( String username,Bill bill ){
        BillApi myAPI = new BillApi();

        Scanner scanner = new Scanner(System.in);

        double amount = bill.getAmount();
        if ( amount > balance) {
            System.out.println("your balance is not enough to complete the transfer " + amount ) ;
            return;
        }
        if ( amount <= 0) {
            System.out.println("invalid amount to transfer" ) ;
            return;
        }

        if (!myAPI.transfer(username , bill))
            System.out.println("sorry couldn't complete the transfer");
        else {
            balance -= amount;
            System.out.println("the amount transferred your current balance is " +balance );
        }
    }

}
