import java.util.Scanner;

public class BankRegisteration  extends RegisterationService{

   bankPayment payment;
   String BankNumber , Registered_Phone;


    BankRegisteration(){
       db = DatabaseService.getInstance();
    }

    @Override public boolean Register(){
        super.Register();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter BankNumber : ");
        this.BankNumber = scanner.nextLine();
        System.out.println("Enter Registered_Phone : ");
        this.Registered_Phone = scanner.nextLine();
        if(db.checkUser(username)){
            System.out.println("username "+username+" alredy exits !");
            return false;
        }
        db.addUser(this);
        return true;

    }




}
