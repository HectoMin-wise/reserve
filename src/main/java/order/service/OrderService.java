package order.service;

import order.entity.Order;
import vo.Member;

import java.sql.SQLException;

public interface OrderService {
    void reserve(Member member) throws SQLException;
    void cancle(Order order) throws SQLException;

    Member strat() throws SQLException;
}
