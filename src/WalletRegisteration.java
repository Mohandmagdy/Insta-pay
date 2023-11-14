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
        return true;
    }
}
