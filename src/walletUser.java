public class walletUser extends User {

    walletUser(String username, String password , String phone ,  String walletNumber , double amount){
        super(username, password, phone);
        this.card = new walletPayment(walletNumber  , amount);
    }

    public walletPayment getWalletNumber() {
        return (walletPayment)this.card;
    }

    public void setWalletNumber(walletPayment wallet) {
        this.card = wallet;
    }

}