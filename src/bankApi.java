public class bankApi implements API {

    public boolean verifyPayment(payment paymentMethod) {
        return paymentMethod instanceof bankPayment;
    }
}
