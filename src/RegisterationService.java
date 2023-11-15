import java.util.Locale;
import java.util.Scanner;
public abstract class RegisterationService {

    InputValidation validation;
    protected  DatabaseService db;

    String username , password , phone;

    RegisterationService(){
        validation = new InputValidation();
    };


    public boolean Register() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Username : ");
            this.username = scanner.nextLine();
            if (!validation.validateUserName(this.username)) {
                System.out.println("User already exists, Try another username");
            } else break;
        }
        System.out.println("Define the pattern for a strong password\n" +
                "At least 8 characters, at least one uppercase letter, one lowercase letter,\n" +
                "one digit, and one special character");
        while (true) {
            System.out.println("Enter password : ");
            this.password = scanner.nextLine();
            if (!validation.isStrongPassword(this.password)) {
                System.out.println("Weak password, Try again");
            } else break;
        }

        while (true) {
            System.out.println("Enter phone (Egyptian numbers only): ");
            this.phone = scanner.nextLine();
            String reply;
            if ((reply = validation.isValidPhoneNumber(this.phone)) != "success") {
                System.out.println(reply + " Try again");
            } else {
                // country code
                this.phone="2"+this.phone;
                break;
            }
        }
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
