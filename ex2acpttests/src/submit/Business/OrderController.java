package submit.Business;

import main.data.OrderInfo;
import main.data.ShowInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderController {
    private ShowController showController;
    private HashMap<OrderInfo,Integer> orders;
    private HashMap<String,ShowInfo> reservations;
    private int orderId = 0;
    public OrderController(ShowController showController){
        this.showController = showController;
        orders = new HashMap<>();
        reservations = new HashMap<>();
    }
    /*
    public String city;
	public String hall;
	public String name;
	public String description;
	public boolean hastime;
	public LocalTime showTime;
	public long showDate;
	public long lastOrderDate;
	public double ticketCost;
     */
    private void increaseId(){
        orderId++;
    }
    public void reserveMemberChairs(int showID, int from, int to) {
        showController.reserve(showID,from,to);
    }
    /*
    public int showId;
	public String name;
	public String phone;
	public int[] chairsIds;
	public int memberId;
     */

    public int newOrder(OrderInfo order) {

        ShowInfo show = showController.getShow(order.showId);


        if (show == null || show.userstoinform.contains(order)|| !checkValidInfo(order)){
            return -1;
        }
        String date1 = show.convertTime(show.lastOrderDate);
        String today =  show.convertTime(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if(sdf.parse(date1).before(sdf.parse(today))){
                return -1;
            }

        } catch (ParseException e) {
            return -1;
        }
        if(!showController.saveChairs(show.hall,order.chairsIds,order.memberId)){
            return -1;
        }
        OrderInfo or = null;
        if((or = existOrder(show.userstoinform,order.name))!= null){
            return orders.get(or);
        }
        //in the end:
        show.userstoinform.add(order);
        orders.put(order,++orderId);
        return orderId;
    }
    /*
    List<String> field1List = entities.stream().map(urEntity -> urEntity.getField1()).collect(Collectors.toList());
     */
    private OrderInfo existOrder(List<OrderInfo> orders,String name){
        int index = -1;
        List<String> names = orders.stream().map(order->order.name).collect(Collectors.toList());
        if ((index = names.indexOf(name)) != -1){
            return orders.get(index);
        }
        return null;
    }

    private boolean checkValidInfo(OrderInfo order){
        return !(order.showId < 1 | order.name == null | order.phone == null) && !order.phone.isEmpty() && order.chairsIds != null && order.chairsIds.length != 0;
    }




    public List<OrderInfo> getWaitings(int id) {
        List<OrderInfo> ans = new LinkedList<>();
        ShowInfo show = showController.getShow(id);
        if((show!=null)&&((ans = show.userstoinform) != null) ){
            return ans;
        }else {
            return ans;
        }
    }
}
