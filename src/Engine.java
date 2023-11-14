import java.util.List;
import java.util.Scanner;

public class Engine {
    private Authentication authentication ;
    private User currentUser ;
    private UserFactory userFactory ;
    Engine(){
        authentication = Authentication.getInstance();
    }


    public void Register(int option){
        if(option == 1){
            BankRegisteration b =  new BankRegisteration();
            //if(b.Register())System.out.println("Account created Successfully");
            b.dd("honda","hondav1");
            return;
        }
        else if(option==2){
            new WalletRegisteration().Register();
            return;
        }
    }
    public void run(){
        // display menu

        System.out.println("Welcome to Insta Pay Application");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1-Log in");
            System.out.println("2-Register");
            System.out.println("3-Exit");
            int choice = scanner.nextInt();

            if(choice==1){

            }

            else if(choice == 2){
                System.out.println("1-Register as BankUser");
                System.out.println("2-Register as WalletUser");
                int choice2 = scanner.nextInt();
                Register(choice2);
            }
            else {
                break;
            }

        }
    }

    void login() {
        List<String> lst = authentication.login() ;
        currentUser = userFactory.getCurrentUser(lst);
    }

}
