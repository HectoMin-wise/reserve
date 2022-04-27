package order.service;

import controller.server.member.entity.Member;
import db.DBConfig;
import db.DBConnection;
import db.Ojdbc;
import order.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {

    public Member member;
    public Order order;
    int seq =1;

    private final DBConnection dbConnection = DBConfig.getDbInstance();
    private Connection conn;



    @Override
    public Order orderSave(Member member,Order order) {

        order = new Order(0,order.getOrder_date(),"0","0",order.getOrder_price(),1,1);

        PreparedStatement pstmt = null;
        conn = dbConnection.getConnection();
        try {
            String sql = "INSERT INTO order_r(order_date,order_price,member_idx) VALUES(?,?,?)";

            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,order.getOrder_date());
            pstmt.setInt(2,order.getOrder_price());
            pstmt.setLong(3,member.getMemberIdx());
            pstmt.executeUpdate();
            System.out.printf(order.getOrder_date());

            conn.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("DB 연결 실패 무언가 잘못됬다.. 드라이버 연결 정보 오류");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("별도의 사유로 연결 실패");
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean orderdelete(int index) {
        PreparedStatement pstmt = null;
        boolean deleteCheck = false;
        try {
            conn = dbConnection.getConnection();
            String sql = "delete from order_r where order_idx=?";
            pstmt =conn.prepareStatement(sql);
            pstmt.setLong(1,index);
            deleteCheck = 1==pstmt.executeUpdate();
            conn.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("DB 연결 실패 무언가 잘못됬다.. 드라이버 연결 정보 오류");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("별도의 사유로 연결 실패");
            e.printStackTrace();

        }
        return deleteCheck;
    }

    @Override
    public List<Order> orderCheck(Member member) {
        List<Order> orders = new ArrayList<>();
        Order order;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            conn = dbConnection.getConnection();
//            String sql = "select order_idx, order_date, order_ from order_r JOIN ";

            String sql = "     SELECT" +
                    "            or2.order_idx, or2.order_date, or2.order_price, h.house_name" +
                    "            FROM order_r or2" +
                    "            LEFT JOIN reservation r ON or2.reservation_idx = r.reservation_idx" +
                    "            LEFT JOIN house h ON r.house_idx = h.house_idx" +
                    "            WHERE or2.member_idx = ?";

            pstmt =conn.prepareStatement(sql);
            pstmt.setLong(1,member.getMemberIdx());
            result = pstmt.executeQuery();

            while (result.next()){
                order = new Order();
                order.setOrder_idx(result.getInt("order_idx"));
                order.setOrder_date(result.getString("order_date"));
                order.setOrder_price(result.getInt("order_price"));
                orders.add(order);
            }
            conn.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("DB 연결 실패 무언가 잘못됬다.. 드라이버 연결 정보 오류");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("별도의 사유로 연결 실패");
            e.printStackTrace();

        }
        return orders;
    }



}
