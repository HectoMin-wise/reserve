package order.service;

import controller.server.member.entity.Member;
import order.entity.Order;



import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    Order orderSave(Member member,Order order);
    boolean orderdelete(int index);
    List<Order> orderCheck();


}
