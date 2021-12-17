package submit.Service;




import main.data.OrderInfo;
import main.data.ShowInfo;
import main.bridge.Bridge;
import submit.Business.UserController;



import java.util.List;

public class Service{
    private final ShowService showService;
    private final OrderService orderService;
    public Service(){
        showService = new ShowService();
        orderService = new OrderService(showService.getController());
    }

    public void addCity(String city) {
        showService.addCity(city);
    }


    public void addHall(String city, String hall, int sits) {
        showService.addHall(city,hall,sits);
    }


    public void addAdmin(String city, String user, String pass) {
        UserController.getInstance().addAdmin(city,user,pass);

    }


    public int addNewShow(String user, String pass, ShowInfo showInfo) {
        return showService.addNewShow(user,pass,showInfo);
    }


    public void reserveMemberChairs(int showID, int from, int to) {
        orderService.reserveMemberChairs(showID,from,to);
    }

    public int newOrder(OrderInfo order) {
        return orderService.newOrder(order);
    }


    public List<OrderInfo> getWaitings(int id) {
        return orderService.getWaitings(id);
    }
}
