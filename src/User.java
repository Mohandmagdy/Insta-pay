public abstract class User {
    protected String username;
    protected String password;


    protected String phone;

    User(String username, String password , String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phone = phoneNumber;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
