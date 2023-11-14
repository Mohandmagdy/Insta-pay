import java.util.List;
import java.util.Scanner;

public class Engine {
    private Authentication authentication;
    private User currentUser;
    private UserFactory userFactory;

    Engine() {
        authentication = Authentication.getInstance();
        userFactory = new UserFactory();
    }

    private boolean register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Register as BankUser");
        System.out.println("2-Register as WalletUser");
        int choice2 = scanner.nextInt();
        if (choice2 == 1) {
            BankRegisteration b = new BankRegisteration();
            if (b.Register())
                System.out.println("Account created Successfully");
            else
                return false;

        } else if (choice2 == 2) {
            WalletRegisteration w = new WalletRegisteration();
            if(w.Register())
                System.out.println("Account created Successfully");
            else
                return false;
        }
        return true;
    }

    private boolean login() {
        List<String> userInfo = authentication.login();
        if (userInfo == null) {
            System.out.println("Wrong username or password.");
            return false;
        }
        currentUser = userFactory.getCurrentUser(userInfo);
        return true;
    }

    private boolean showServices(){
        Scanner scanner = new Scanner(System.in);
        if (currentUser instanceof bankUser){
            System.out.println("1- transfer to wallet");
            System.out.println("2- transfer to bank");
            System.out.println("3- transfer to insta Pay account");
            System.out.println("4- pay bills");
            System.out.println("5- logout");
            int choice = scanner.nextInt();
            //write response code
            if(choice == 5){
                //logout
                return false;
            }
        } else{
            System.out.println("1- transfer to wallet");
            System.out.println("2- transfer to insta Pay account");
            System.out.println("3- pay bills");
            System.out.println("4- logout");
            int choice = scanner.nextInt();
            //write response code
            if(choice == 4){
                //logout
                return false;
            }
        }

        return true;
    }

    public void run() {
        // display menu

        System.out.println("Welcome to Insta Pay Application");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1-Log in");
            System.out.println("2-Register");
            System.out.println("3-Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                if (login()) {
                    System.out.println("Welcome " + currentUser.getUsername());
                    while(true) {
                        if(!showServices())break;
                    }
                }
            } else if (choice == 2) {
                register();
            } else {
                break;
            }
        }
    }
}
