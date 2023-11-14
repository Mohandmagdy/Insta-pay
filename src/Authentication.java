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
        String username = ""  , password = "" ;

        // print menu and get username and password

        if (db.login(username, password)) {
            return db.getUser(username);
        }
        else return new ArrayList<>() ;
    }

}
