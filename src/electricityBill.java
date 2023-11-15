import java.util.Date;
import java.util.Random;

public class electricityBill extends Bill {

    public electricityBill(String id) {
        this.ID = id;
        Random rand = new Random();
        this.amount = rand.nextDouble(3000);
        this.metricNumber = rand.nextInt(3000);
    }

    int metricNumber;

    public int getMetricNumber() {
        return metricNumber;
    }

    public void setMetricNumber(int metricNumber) {
        this.metricNumber = metricNumber;
    }

    public String getDescription() {
        return "ID:" + ID + ", Amount:" + amount  + ", Usage:" + metricNumber;
    }
}
