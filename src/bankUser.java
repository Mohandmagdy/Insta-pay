public class bankUser extends User {
    bankPayment card;
    bankUser(String username, String password , String phone , String bankNumber , String registeredPhoneNumber , double amount ) {
        super(username, password, phone);
        card = new bankPayment(bankNumber, registeredPhoneNumber , amount);
    }

    public String getAccountNumber() {
        return card.getAccountNumber();
    }


    public void setBankNumber(String bankNumber) {
        this.card.setAccountNumber(bankNumber);
    }

}
