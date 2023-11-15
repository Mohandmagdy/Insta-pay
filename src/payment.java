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

}
