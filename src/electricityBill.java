import java.util.Date;

public class electricityBill extends Bill {

    public electricityBill(String id, double amount, boolean status, Date date) {
        super(id, amount, status);
    }

    String metricNumber;

    public String getMetricNumber() {
        return metricNumber;
    }

    public void setMetricNumber(String metricNumber) {
        this.metricNumber = metricNumber;
    }
}
