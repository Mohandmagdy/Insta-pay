public class walletApi implements API{
    @Override
    public boolean verifyPayment(payment paymentMethod) {
        return paymentMethod instanceof walletPayment;
    }
}
