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
        try{
        PreparedStatement pstmt = this.connection.prepareStatement("INSERT INTO Users (username, password,phone,type) VALUES (?, ?,?,?)");
        pstmt.setString(1, b.username);
        pstmt.setString(2, b.password);
        pstmt.setString(3, b.phone);
        int type = (b instanceof BankRegisteration ? 1 : 0);
        pstmt.setInt(4, type);
        // Execute the query
        pstmt.executeUpdate();
        // Close the connections
        pstmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
       if(b instanceof BankRegisteration)  {
           try{
               PreparedStatement pstmt = this.connection.prepareStatement("INSERT INTO BankUser (UserID, BankNumber,registeredPhoneNumber,amount) VALUES (?,?,?,?)");
               System.out.println(b.username );
               pstmt.setString(1, b.username);
               pstmt.setString(2, ((BankRegisteration) b).BankNumber);
               pstmt.setString(3, ((BankRegisteration) b).Registered_Phone);
               pstmt.setDouble(4, (Math.random()*10000)+350);
               // Execute the query
               pstmt.executeUpdate();
               // Close the connections
               pstmt.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       else if(b instanceof WalletRegisteration){
           try{
               PreparedStatement pstmt = this.connection.prepareStatement("INSERT INTO WalletUser (UserId, walletNumber,amount) VALUES (?, ?,?)");
               pstmt.setString(1, b.username);
               pstmt.setString(2, ((WalletRegisteration) b).WalletNumber);
               pstmt.setDouble(3, (Math.random()*10000)+350);

               // Execute the query
               pstmt.executeUpdate();
               // Close the connections
               pstmt.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
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
                return true;
            } else {
                return false;
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
