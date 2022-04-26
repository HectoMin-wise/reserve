package order.service;

import order.entity.Order;
import vo.Member;

import java.sql.SQLException;

public interface OrderService {

    Member memberLogin() throws SQLException;
    Order orderSave(Member member);
    Order orderdelete(Order order);

    void orderCheck();


}
