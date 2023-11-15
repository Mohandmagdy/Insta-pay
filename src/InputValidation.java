import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InputValidation {
    DatabaseService db;

    public InputValidation() {
        db = DatabaseService.getInstance();
    }

    public boolean validateUserName(String userName) {
        return !db.checkUser(userName);
    }
    public  String isValidPhoneNumber(String phoneNumber) {
        // Define the pattern for a valid Egyptian phone number
        // Valid formats: +20 10 digits, 01X-XXX-XXXX, 01X.XXX.XXXX, 01X XXX XXXX
        String phoneRegex = "^(\\+20)?[\\s-]?01[0-9]{9}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(phoneRegex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(phoneNumber);

        // Check if the phone number matches the pattern
        if (!matcher.matches()) {
            return "Invalid phone number";
        }
        if (db.checkPhone(phoneNumber)) {
            return "Phone number is registered before";
        }
        return "success";
    }

    public  boolean isStrongPassword(String password) {
        // Define the pattern for a strong password
        // At least 8 characters, at least one uppercase letter, one lowercase letter,
        // one digit, and one special character
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(passwordRegex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(password);

        // Check if the password matches the pattern
        return matcher.matches();
    }

    public  String isValidRegisteredPhoneNumber(String phoneNumber) {
        // Define the pattern for a valid Egyptian phone number
        // Valid formats: +20 10 digits, 01X-XXX-XXXX, 01X.XXX.XXXX, 01X XXX XXXX
        String phoneRegex = "^(\\+20)?[\\s-]?01[0-9]{9}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(phoneRegex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(phoneNumber);

        // Check if the phone number matches the pattern
        if (!matcher.matches()) {
            return "Invalid phone number";
        }
        if (db.checkRegisteredPhoneNumber(phoneNumber)) {
            return "Phone number is registered before";
        }
        return "success";
    }


    public  String isValidBankAccNumber(String BankNumber) {
        if (BankNumber.length() != 14) return "invalid BankNumber";
        for (int i = 0; i < 14; i++) {
            if (BankNumber.charAt(i) < '0' || BankNumber.charAt(i) > '9') return "invalid BankNumber";
        }

        if (db.checkBankNumber(BankNumber)) {
            return "Bank number is registered before";
        }

        return "success";
    }

    public  String isValidWalletNumber(String walletNumber) {
        // Define the pattern for a valid Egyptian phone number
        // Valid formats: +20 10 digits, 01X-XXX-XXXX, 01X.XXX.XXXX, 01X XXX XXXX
        String walletRegex = "^(\\+20)?[\\s-]?01[0-9]{9}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(walletNumber);

        // Create a matcher object
        Matcher matcher = pattern.matcher(walletNumber);

        // Check if the phone number matches the pattern
        if (!matcher.matches()) {
            return "Invalid wallet number";
        }
        if (db.checkWalletNumber(walletNumber)) {
            return "Wallet is registered before";
        }
        return "success";
    }


}
