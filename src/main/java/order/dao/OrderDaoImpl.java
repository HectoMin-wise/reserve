package order.dao;

import db.DBConnection;
import db.Ojdbc;
import order.entity.Order;
import order.service.OrderService;
import order.querycontroller.QueryController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private DBConnection dbConnection = new Ojdbc();
    private Connection conn = dbConnection.getConnection();
    private QueryController qc = new QueryController();



    @Override
    public Long insertOrder(OrderService order) {
        return 12L;
    }

    @Override
    public List<Order> getOrderList(int page) {
//        List<Order> orderList = new ArrayList<>();
//
//        try {
//            String query = "SELECT order_idx FROM order_r";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Order order = new Order();
//                order.setOrder_idx(rs.getInt("order_idx"));
//                orderList.add(order);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return null;
    }

    @Override
    public Order getOreder(int order_idx) {
        Order order = new Order();

        try {
            ResultSet rs = qc.selectNotice(conn, order_idx);

            while (rs.next()) {
                order.setOrder_idx(rs.getInt("oder_idx"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public void delOrder(int notice_idx) {

    }

    @Override
    public void hideOrder(int notice_idx) {

    }
}
