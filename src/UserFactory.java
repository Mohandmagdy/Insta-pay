import java.util.* ;
public class UserFactory {
    public User getCurrentUser(List<String> lst){
        if (lst.size() == 6){// meaning bankUser
            return new bankUser(lst.get(0),lst.get(1),lst.get(2),lst.get(3),lst.get(4) ,Double.parseDouble(lst.get(5)));
        }
        return new walletUser(lst.get(0),lst.get(1),lst.get(2),lst.get(3) , Double.parseDouble(lst.get(4)) ) ;
    }



}

