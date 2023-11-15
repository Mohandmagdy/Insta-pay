import java.util.*;
public class internetBill extends Bill {
    int DataUsage;

    public internetBill(String id) {
        this.ID = id;
        Random rand = new Random();
        this.amount = rand.nextDouble(3000);
        this.DataUsage = rand.nextInt(3000);

    }

    public int getDataUsage() {
        return DataUsage;
    }


    public void setDataUsage(int dataUsage) {
        DataUsage = dataUsage;
    }

    public String getDescription() {
        return "ID:" + ID + ", Amount:" + amount  + ", Usage:" + DataUsage;
    }
}
