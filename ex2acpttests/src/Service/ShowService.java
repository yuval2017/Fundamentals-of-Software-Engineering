package Service;


import Business.ShowController;
import main.data.ShowInfo;

public class ShowService {
    private ShowController controller;
    public ShowService (){
        controller = new ShowController();
    }

    public void addCity(String city) {
        controller.addCity(city);
    }
    public ShowController getController (){
        return controller;
    }

    public void addHall(String city, String hall, int sits) {
        controller.addHall(city,hall,sits);
    }



    public int addNewShow(String user, String pass, ShowInfo showInfo) {
        return controller.addNewShow(user,pass,showInfo);
    }
}
