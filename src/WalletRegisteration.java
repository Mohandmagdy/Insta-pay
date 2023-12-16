import java.util.Scanner;

public class WalletRegisteration extends RegisterationService {
    public String WalletNumber;

    WalletRegisteration() {
        db = DatabaseService.getInstance();
    }


    @Override
    public boolean Register() {
        super.Register();
        Scanner scanner = new Scanner(System.in);
        String reply;
        while (true) {
            System.out.println("Enter WalletNumber : ");
            this.WalletNumber = scanner.nextLine();
            if ((reply = validation.isValidWalletNumber(this.WalletNumber)) != "success") {
                System.out.println(reply + " Try again");
            } else {
                break;
            }
        }
        
        db.addUser(this);
        return true;
    }
}
