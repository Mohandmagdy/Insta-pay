public abstract class API {
    DatabaseService db ;
    private String name ;
    public String getName() {
        return name ;
    }
    API(String name) {
        db = DatabaseService.getInstance();
        this.name = name ;
    }
    public abstract boolean transfer (String senderAccount , String receiverAccount ,double amount ) ;
    

}
