import java.util.*;

public abstract class Bill {
    String ID;
    double amount;


    public double getAmount() {
        return amount;
    }



    public String getID() {
        return ID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public abstract String getDescription() ;

}
