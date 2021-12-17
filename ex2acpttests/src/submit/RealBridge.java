package submit;
import main.bridge.Bridge;
import main.data.OrderInfo;
import main.data.ShowInfo;
import submit.Service.Service;

import java.util.List;

public class RealBridge implements Bridge{
    public Service service = new Service();
    @Override
    public void addCity(String city) {
        service.addCity(city);
    }

    @Override
    public void addHall(String city, String hall, int sits) {
        service.addHall(city,hall,sits);
    }

    @Override
    public void addAdmin(String city, String user, String pass) {
        service.addAdmin(city,user,pass);
    }

    @Override
    public int addNewShow(String user, String pass, ShowInfo showInfo) {
        return service.addNewShow(user,pass,showInfo);
    }

    @Override
    public void reserveMemberChairs(int showID, int from, int to) {
        service.reserveMemberChairs(showID,from,to);
    }

    @Override
    public int newOrder(OrderInfo order) {
        return service.newOrder(order);
    }

    @Override
    public List<OrderInfo> getWaitings(int id) {
        return service.getWaitings(id);
    }
}
