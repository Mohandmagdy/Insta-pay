import java.util.* ;
public class Authentication {
    private DatabaseService db ;
    private static Authentication authentication ;
    private Authentication(){
        db = DatabaseService.getInstance() ;
    }

    public static Authentication  getInstance(){
        if (authentication == null){
            authentication  = new Authentication ();
        }
        return authentication ;
    }
    public List<String> login(){
        String username, password;
        System.out.println("Please enter your username and password");
        System.out.print("Username: ");
        Scanner myScanner = new Scanner((System.in));
        username = myScanner.nextLine();
        System.out.print("Password: ");
        password = myScanner.nextLine();

        return db.login(username, password);
    }
}
