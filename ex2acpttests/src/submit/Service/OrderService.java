package submit.Service;


import main.data.OrderInfo;
import main.data.ShowInfo;
import submit.Business.OrderController;
import submit.Business.ShowController;

import java.util.List;

public class OrderService {
    private OrderController controller;
    public OrderService(ShowController showController){
        controller = new OrderController(showController );
    }
    public void reserveMemberChairs(int showID, int from, int to) {
        controller.reserveMemberChairs(showID,from,to);
    }

    public int newOrder(OrderInfo order) {
        return controller.newOrder(order);
    }

    public List<OrderInfo> getWaitings(int id) {
        return controller.getWaitings(id);
    }
}
