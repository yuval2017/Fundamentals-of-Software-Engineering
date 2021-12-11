package Business;

import main.data.OrderInfo;
import main.data.ShowInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ShowController {
    private HashMap<String, List<String>> citiesAndHalls;
    private HashMap<String,int[]> hallsSits;
    private HashMap<Integer,ShowInfo> shows;
    private HashMap<String,Integer> showsOrders;
    private int showID = 0;
    public ShowController(){
        citiesAndHalls = new HashMap<>();
        hallsSits = new HashMap<>();
        shows = new HashMap<>();
        showsOrders = new HashMap<>();
    }
    public boolean addCity(String city) {
        if(!citiesAndHalls.containsKey(city)){
            citiesAndHalls.put(city,new LinkedList<>());
            return true;
        }
        return false;
    }

    public boolean addHall(String city, String hall, int sits) {
        if(citiesAndHalls.containsKey(city)){
            List<String> halls = citiesAndHalls.get(city);
            if(hallsSits.containsKey(hall)){
                return false;
            }else {
                halls.add(hall);
                hallsSits.put(hall,new int[sits]);
                return true;
            }
        }
        return false;
    }
    /*
    public int showId;
	public String name;
	public String phone;
	public int[] chairsIds;
	public int memberId;
     */
    public void usersToInform(List<OrderInfo> informs){
        for (OrderInfo orderInfo: informs){
            saveChairs(shows.get(orderInfo.showId).hall,orderInfo.chairsIds,orderInfo.memberId);
        }
    }
    public boolean saveChairs(String hall,int[] chairs ,int memberId){
        int[] chairsToChange = hallsSits.get(hall).clone();
        for (int chair: chairs){
            if(memberId <= 0 && chairsToChange[chair] == -2){
                return false;
            }
            chairsToChange[chair] = memberId;
        }
        hallsSits.replace(hall,chairsToChange);
        return true;
    }


    public int addNewShow(String user, String pass, ShowInfo showInfo) {
        UserController users = UserController.getInstance();

        if(!users.isAdmin(user,pass)){
            return -1;
        }
        String city = users.getCity(user);
        if(city == null || !city.equals(showInfo.city)){
            return -1;
        }

        String date1 = showInfo.convertTime(showInfo.lastOrderDate);
        String date2 = showInfo.convertTime(showInfo.showDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if(sdf.parse(date1).after(sdf.parse(date2))){
                return -1;
            }
        } catch (ParseException e) {
            return -1;
        }

        if((!showInfo.hastime&&(showInfo.showTime != null)) | showInfo.hall == null| !citiesAndHalls.containsKey(UserController.getInstance().getCity(user))){
            return -1;
        }
        increaseSows();
        shows.put(showID,showInfo);
        usersToInform(showInfo.userstoinform);
        return showID;
    }
    public boolean reserve(int showID, int from, int to){
        if(!shows.containsKey(showID)){
            return false;
        }
        int [] showChairs = hallsSits.get(shows.get(showID).hall);
        if(from < 0 | to >= showChairs.length){
            return false;
        }
        for (int i = from; i < to ; i++){
            if(showChairs[i] == -2){
                return false;
            }
            showChairs[i] = -2;
        }
        hallsSits.replace(shows.get(showID).hall,showChairs);
        return true;
    }

    public ShowInfo getShow(int showID) {
        return shows.get(showID);
    }

    private void increaseSows(){
        showID++;
    }
}
