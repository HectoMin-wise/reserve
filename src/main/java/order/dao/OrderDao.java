package order.dao;

import order.entity.Order;
import order.service.OrderService;

import java.util.List;

public interface OrderDao {
    Long insertOrder(OrderService order);
    List<Order> getOrderList(int page);
    Order getOreder(int order_idx);
    void delOrder(int notice_idx);
    void hideOrder(int notice_idx);
}
