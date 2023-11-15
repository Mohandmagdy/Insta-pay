import java.util.Date;
import java.util.Random;

public class waterBill extends Bill{
    int usage;

    public waterBill(String id) {
        this.ID = id;
        Random rand = new Random();
        this.amount = rand.nextDouble(3000);
        this.usage = rand.nextInt(3000);
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }
    public String getDescription() {
        return "ID:" + ID + ", Amount:" + amount  + ", Usage:" + usage;
    }
}
