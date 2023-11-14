import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public List<String> login(String user, String pwd){
        List<String> user_details = new ArrayList<>();
        try{
            // Create a statement
            PreparedStatement pstmt = this.connection.prepareStatement("SELECT * FROM Users WHERE username = ? and password= ? ");
            pstmt.setString(1, user);
            pstmt.setString(2, pwd);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int type = rs.getInt("type");
                rs.close();
                pstmt.close();
                user_details.add(user);
                user_details.add(pwd);
                if(type==1){
                    pstmt = this.connection.prepareStatement("SELECT * FROM BankUser WHERE UserID = ?");
                    pstmt.setString(1, user);
                    rs = pstmt.executeQuery();

                    if(rs.next()){
                        user_details.add(rs.getString("BankNumber"));
                        user_details.add(rs.getString("registeredPhoneNumber"));
                        user_details.add(String.valueOf(rs.getDouble("amount")));
                        pstmt.close();
                        rs.close();
                    }

                 return null;
                }
                else{
                    pstmt = this.connection.prepareStatement("SELECT * FROM WalletUser WHERE UserID = ?");
                    pstmt.setString(1, user);
                    if(rs.next()) {
                        user_details.add(rs.getString("WalletNumber"));
                        user_details.add(String.valueOf(rs.getDouble("amount")));
                        pstmt.close();
                        rs.close();
                    }

                    return null;

                }
            }

            return user_details;

        }
        catch (SQLException e) {
            throw new IllegalStateException("error in the database!", e);
        }
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

            // Process the result

            boolean exists = rs.next();

            if (exists) {
                return true;
            } else {
                return false;
            }

        }
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }





    ;
    
}
