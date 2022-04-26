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
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {

    public Member member;
    public Order order;
    int seq =1;

    private DBConnection dbConnection = DBConfig.getDbInstance();
    private Connection conn;



    @Override
    public Member memberLogin() throws SQLException {
        Scanner sc = new Scanner(System.in);
//        System.out.println("아이디 : ");
//        String id = sc.nextLine();
//        System.out.println("비밀번호 :");
//        String pw = sc.nextLine();


        while (true) {
            System.out.println("예약 : 1 | 취소 : 2 | 끝내기 : 3 | 조회 : 4");
            int choice = sc.nextInt();

            if (choice == 1) {
//                orderSave(member);
            } else if (choice == 2) {
                orderdelete(order);
            } else if (choice==3){
                break;
            } else if (choice==4){
                orderCheck();
            }
        }
        return null;
//        return new Member(seq++,id, pw);
    }



    @Override
    public Order orderSave(Member member,Order order) {

        order = new Order(0,order.getOrder_date(),"0","0",order.getOrder_price(),1,1);

        PreparedStatement pstmt = null;
        conn = dbConnection.getConnection();
        try {
            String sql = "INSERT INTO order_r(order_date,order_price) VALUES(?,?)";

            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,order.getOrder_date());
            pstmt.setInt(2,order.getOrder_price());
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
    public Order orderdelete(Order order) {
        PreparedStatement pstmt = null;
        try {
            conn = dbConnection.getConnection();

            System.out.println("연결성공");
            Scanner sc = new Scanner(System.in);
            System.out.println("없애고 싶은 번호");

            String sql = "delete from order_r where order_idx=?";
            pstmt =conn.prepareStatement(sql);

            int del_num = sc.nextInt();
            pstmt.setLong(1,del_num);

            pstmt.executeUpdate();

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
    public void orderCheck() {
        PreparedStatement pstmt = null;
        ResultSet result = null;
        Scanner sc = new Scanner(System.in);
        try {
            conn = dbConnection.getConnection();

       ;

//            String sql = "select * from order_r";
            String sql = "     SELECT" +
                    "            or2.order_idx, or2.order_date, or2.order_price, h.house_name" +
                    "            FROM order_r or2" +
                    "            JOIN reservation r ON or2.reservation_idx = r.reservation_idx" +
                    "            join house h ON r.house_idx = h.house_idx" +
                    "            where or2.member_idx = ?";

            pstmt =conn.prepareStatement(sql);

            System.out.println("값넣어라");
            int num = sc.nextInt();
            pstmt.setInt(1,num);


            result = pstmt.executeQuery();

            while (result.next()){
                System.out.println(result.getString("order_idx") +","
                        +result.getString("order_date")+","
                        +result.getString("order_price"));


            }
            conn.close();
            pstmt.close();
//            sc.close();

        } catch (SQLException e) {
            System.out.println("DB 연결 실패 무언가 잘못됬다.. 드라이버 연결 정보 오류");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("별도의 사유로 연결 실패");
            e.printStackTrace();

        }
    }


}
