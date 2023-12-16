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

            String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11670675";
            String username = "sql11670675";
            String password = "z86dSe1zaq";
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
                String Phone = rs.getString("phone");
                rs.close();
                pstmt.close();
                user_details.add(user);
                user_details.add(pwd);
                user_details.add(Phone);
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
                        return user_details;
                    }
                    return null;
                }
                else{
                    pstmt = this.connection.prepareStatement("SELECT * FROM WalletUser WHERE UserID = ?");
                    pstmt.setString(1, user);
                    rs = pstmt.executeQuery();
                    if(rs.next()) {
                        user_details.add(rs.getString("WalletNumber"));
                        user_details.add(String.valueOf(rs.getDouble("amount")));
                        pstmt.close();
                        rs.close();
                        return user_details;
                    }
                    return null;
                }
            } else{
                return null;
            }
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
    public boolean checkPhone(String phoneNumber){
        try {
            // Create a prepared statement
            PreparedStatement pstmt = this.connection.prepareStatement("SELECT * FROM Users WHERE phone = ?");
            pstmt.setString(1, phoneNumber);

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

    public boolean checkBankNumber(String bankNumber) {
        try {
            // Create a prepared statement
            PreparedStatement pstmt = this.connection.prepareStatement("SELECT * FROM BankUser WHERE BankNumber = ?");
            pstmt.setString(1, bankNumber);

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

    public boolean checkRegisteredPhoneNumber(String RegisteredPhoneNumber) {
        try {
            // Create a prepared statement
            PreparedStatement pstmt = this.connection.prepareStatement("SELECT * FROM BankUser WHERE RegisteredPhoneNumber = ?");
            pstmt.setString(1, RegisteredPhoneNumber);

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
    public boolean checkWalletNumber(String walletNumber) {
        try {
            // Create a prepared statement
            PreparedStatement pstmt = this.connection.prepareStatement("SELECT * FROM WalletUser WHERE walletNumber = ?");
            pstmt.setString(1, walletNumber);

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
    public void updateBalance( String userName , double amount ){

        String query1 = "SELECT type FROM Users WHERE username = ?";
        String query2 = "UPDATE %s SET amount = ? WHERE UserID = ?";
        String query3 = "SELECT amount FROM %s WHERE UserID = ?";


        try{
            PreparedStatement selectStatement = this.connection.prepareStatement(query1);
            selectStatement.setString(1, userName);

            ResultSet rs = selectStatement.executeQuery() ;
            int isBankUser = 0 ;
            if (rs.next())
                isBankUser = rs.getInt("type") ;

            String tableName = ( (isBankUser > 0) ? "BankUser" : "WalletUser");

            query3 = String.format(query3, tableName);
            query2 = String.format(query2, tableName);

            PreparedStatement selectStatement2 = this.connection.prepareStatement(query3);

            selectStatement2.setString(1, userName);

            ResultSet rs2 = selectStatement2.executeQuery() ;
            double currentBalance = 0 ;
            if (rs2.next())
                currentBalance = rs2.getDouble("amount");

            PreparedStatement updateStatement  = connection.prepareStatement(query2);

            updateStatement.setDouble(1, currentBalance - amount);
            updateStatement.setString(2, userName);
            updateStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }
}
