public abstract class RegisterationService {
    protected String username;
    protected String password;
    protected String phone;

    RegisterationService(){};
    RegisterationService(String username , String password , String phone){
        this.username = username; this.password=password; this.phone=phone;
    }


}
