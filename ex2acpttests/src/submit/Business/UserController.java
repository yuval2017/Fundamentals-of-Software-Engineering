package submit.Business;

import java.util.HashMap;


public class UserController {
    private static UserController controller = null;
    private final HashMap<String,String> admins;
    private final HashMap<String,String> adminsCity;
    public static UserController getInstance(){
        if(controller == null){
            controller = new UserController();
        }
        return controller;
    }

    private UserController (){
        admins = new HashMap<>();
        adminsCity = new HashMap<>();
    }
    public boolean addAdmin(String city, String user, String pass){
        if(admins.containsKey(user)){
            return false;
        }else{
            admins.put(user,pass);
            adminsCity.put(user,city);
        }
        return true;
    }
    public boolean isAdmin(String user,String pass){
        return admins.containsKey(user) && (admins.get(user).equals(pass));
    }
    public String getCity(String user){
      return adminsCity.get(user);
    }
}
