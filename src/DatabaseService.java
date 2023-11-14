import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DatabaseService {
    private static DatabaseService instance;
    private  Connection connection;


    private DatabaseService() {

        try {

            String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11661754";
             String username = "sql11661754";
             String password = "RZs6ekfgg3";
             Connection connection= DriverManager.getConnection(url, username, password) ;

           System.out.println("Connecting to the database...");
            System.out.println("Connected successfully!");
            this.connection = connection;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }

        return instance;

    }




    public boolean login(String username, String password){
        // check if valid username and password
        return true ;
    }

    public void addUser(RegisterationService b){
       if(b instanceof BankRegisteration)  {
           System.out.println("bank");
       }
       else if(b instanceof WalletRegisteration){
           System.out.println("wallet");
       }
       else{
           System.out.println("btngan");
       }
    }

    public boolean checkUser(String username){
        try {
            // Create a prepared statement
            PreparedStatement pstmt = this.connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            pstmt.setString(1, username);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            boolean exist = rs.next();

            if (rs.next()) {
                return false;
            } else {
                return true;
            }

        }
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }



    public List<String> getUser(String username) {
        List<String> user = new ArrayList<>();

        // make query using the username to get the rest of information

        return user;
    }

    ;
    
}
