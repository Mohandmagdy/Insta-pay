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
        System.out.println("0- logout");
        System.out.println("1- transfer to insta Pay account");
        System.out.println("2- pay bills");
        System.out.println("3- inquire balance");
        System.out.println("4- transfer to wallet");

        if (currentUser instanceof bankUser){
            System.out.println("5- transfer to bank");
        }

        int choice = scanner.nextInt();
        if (choice>5 || choice < 0) {
            System.out.println("Invalid choice , please try again") ;
            return true;
        }
        switch (choice) {
            case 0:
                return false ;
            case 1:
                currentUser.makeInstaPay();
                break ;
            case 2:
                currentUser.makeBillPayment();
                break;
            case 3:
                System.out.println("your account balance is : " + currentUser.getBalance()) ;
                break;
            case 4:
                currentUser.makeWalletPayment();
                break;
            case 5:
                if (currentUser instanceof bankUser)
                    ((bankUser)currentUser).makeBankPayment() ;
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
