public class walletUser extends User {
    walletPayment wallet;

    walletUser(String username, String password , String phone ,  String walletNumber , double amount){
        super(username, password, phone);
        this.wallet = new walletPayment(walletNumber  , amount);
    }

    public walletPayment getWalletNumber() {
        return wallet;
    }

    public void setWalletNumber(walletPayment wallet) {
        this.wallet = wallet;
    }

}