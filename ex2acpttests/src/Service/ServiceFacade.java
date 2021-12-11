package Service;

import Business.ShowController;
import Business.UserController;
import main.data.OrderInfo;
import main.data.ShowInfo;
import main.bridge.Bridge;
import java.util.List;

public class ServiceFacade implements Bridge{
    private final ShowService showService;
    private final OrderService orderService;
    public ServiceFacade(){
        showService = new ShowService();
        orderService = new OrderService(showService.getController());
    }
    @Override
    public void addCity(String city) {
        showService.addCity(city);
    }

    @Override
    public void addHall(String city, String hall, int sits) {
        showService.addHall(city,hall,sits);
    }

    @Override
    public void addAdmin(String city, String user, String pass) {
        UserController.getInstance().addAdmin(city,user,pass);

    }

    @Override
    public int addNewShow(String user, String pass, ShowInfo showInfo) {
        return showService.addNewShow(user,pass,showInfo);
    }

    @Override
    public void reserveMemberChairs(int showID, int from, int to) {
        orderService.reserveMemberChairs(showID,from,to);
    }

    @Override
    public int newOrder(OrderInfo order) {
        return orderService.newOrder(order);
    }

    @Override
    public List<OrderInfo> getWaitings(int id) {
        return orderService.getWaitings(id);
    }
}
