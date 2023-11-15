import java.util.*;

public abstract class Bill {
    String ID;
    double amount;
    boolean status;

    public Bill(String id, double amount, boolean status) {
        this.ID = id;
        this.amount = amount;
        this.status = status;
    }
    public double getAmount() {
        return amount;
    }

    public boolean isStatus() {
        return status;
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

    public void setStatus(boolean status) {
        this.status = status;
    }
}
