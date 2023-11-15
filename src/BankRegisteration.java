import java.util.Scanner;

public class BankRegisteration  extends RegisterationService{

   bankPayment payment;
   String BankNumber , Registered_Phone;


    BankRegisteration(){
       db = DatabaseService.getInstance();
    }



    @Override public boolean Register() {
        String reply;
        super.Register();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter BankNumber (14 Digits): ");
            this.BankNumber = scanner.nextLine();

            if ((reply = validation.isValidBankAccNumber(BankNumber)) != "success") {
                System.out.println(reply + " Try again");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Enter Registered_Phone : ");
            this.Registered_Phone = scanner.nextLine();
            if ((reply = validation.isValidRegisteredPhoneNumber(this.Registered_Phone)) != "success") {
                System.out.println(reply + " Try again");
            } else {
                break;
            }
        }

        db.addUser(this);
        return true;
    }




}
