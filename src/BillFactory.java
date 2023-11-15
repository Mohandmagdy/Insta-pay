import java.util.Scanner;

public class BillFactory {
     public static Bill getBill() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Available  Bills : ");
         Bill bill1 = new internetBill("1235654");
         Bill bill2 = new electricityBill("23156");
         Bill bill3 = new waterBill("32021");

         System.out.println("1- " + bill1.getDescription());
         System.out.println("2- " + bill2.getDescription());
         System.out.println("3- " + bill3.getDescription());
         while (true) {
             int choice = scanner.nextInt();
             if (choice == 1) return bill1;
             else if (choice == 2) return bill2;
             else if (choice == 3) return bill3;
             else return null;
         }
     }
}
