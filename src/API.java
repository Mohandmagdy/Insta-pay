public abstract class API {
    DatabaseService db ;
    API(){
        db = DatabaseService.getInstance();
    }
    public abstract boolean transfer (String senderAccount , String receiverAccount ,double amount ) ;
    

}
