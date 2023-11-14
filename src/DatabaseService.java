import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class DatabaseService {
    private static DatabaseService instance;

    private DatabaseService() {}
    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }

    public void connect(){
        String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11661754";
        String username = "sql11661754";
        String password = "RZs6ekfgg3";

        System.out.println("Connecting to the database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }
    public boolean login(String username, String password){
        // check if valid username and password
        return true ;
    }

    public List<String> getUser(String username) {
        List<String> user = new ArrayList<>();

        // make query using the username to get the rest of information

        return user;
    }

    ;
    
}
