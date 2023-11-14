import java.util.Scanner;
public abstract class RegisterationService {


    protected  DatabaseService db;

    String username , password , phone;

    RegisterationService(){

    };


    public boolean Register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username : ");
        this.username = scanner.nextLine();
        System.out.println("Enter password : ");
        this.password = scanner.nextLine();
        System.out.println("Enter phone : ");
        this.phone = scanner.nextLine();
        return true;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getPhone(){
        return phone;
    }








}
