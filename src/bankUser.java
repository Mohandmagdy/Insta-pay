public class bankUser extends User {

    bankUser(){};
    bankUser(String username, String password , String phone , String bankNumber , String registeredPhoneNumber , double amount ) {
        super(username, password, phone);
        card = new bankPayment(bankNumber, registeredPhoneNumber , amount);
    }

    public String getAccountNumber() {
        return ((bankPayment)card).getAccountNumber();
    }


    public void setBankNumber(String bankNumber) {
        ((bankPayment)card).setAccountNumber(bankNumber);
    }

    public void makeBankPayment(){
        ((bankPayment)card).pay(new bankApi() , username );
    }
}
