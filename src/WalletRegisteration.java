import java.util.Scanner;

public class WalletRegisteration extends RegisterationService {
    public String WalletNumber;

    WalletRegisteration(){
        db = DatabaseService.getInstance();
    };

    @Override
    public boolean Register() {
        super.Register();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter WalletNumber : ");
        this.WalletNumber = scanner.nextLine();
        if(db.checkUser(this.username)){
            System.out.println("username "+this.username+" alredy exits !");
            return false;
        }
        else {
            db.addUser(this);
            return true;
        }
    }
}
