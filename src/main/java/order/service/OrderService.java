package order.service;

import controller.server.member.entity.Member;
import order.entity.Order;


import java.sql.SQLException;

public interface OrderService {

    Member memberLogin() throws SQLException;
    Order orderSave(Member member,Order order);
    Order orderdelete(Order order);

    void orderCheck();


}
