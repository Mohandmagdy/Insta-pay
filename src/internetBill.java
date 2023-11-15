import java.util.*;
public class internetBill extends Bill {
    String ISP, DataUsage;

    public internetBill(String id, double amount, boolean status, Date date) {
        super(id, amount, status);
    }

    public String getDataUsage() {
        return DataUsage;
    }

    public String getISP() {
        return ISP;
    }

    public void setISP(String ISP) {
        this.ISP = ISP;
    }

    public void setDataUsage(String dataUsage) {
        DataUsage = dataUsage;
    }
}
