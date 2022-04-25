package order.service;

import admin.notice.querycontroller.QueryController;
import db.DBConnection;
import db.Ojdbc;
import order.entity.Order;
import vo.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {

    public  Member member;
    public Order order;
    int seq =1;

    private DBConnection dbConnection = new Ojdbc();
    private Connection conn = dbConnection.getConnection();

    public Member strat() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 : ");
        String id = sc.nextLine();
        System.out.println("비밀번호 :");
        String pw = sc.nextLine();

        System.out.println("예약 : 1 | 취소 : 2 | 끝내기 : 3");

        int choice = sc.nextInt();
        if (choice==1){
            reserve(member);
        }else if(choice == 2){
            cancle(order);
        }else {
            sc.close();
        }
        return new Member(seq++,id, pw);
    }

    public static Connection dbConn;
    @Override
    public void reserve(Member member) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("예약 날짜를 선택해 주세요");
        String order_date = sc.nextLine();
//        String cancle_date = sc.nextLine();
//        String order_state= sc.nextLine();
        System.out.println("가격을 적어주세요");
        int order_price = sc.nextInt();

//        OrderService order = new OrderService(member.getMember_idx(),order_date,order_price);
        Order order = new Order(0,order_date,"0","0",order_price);
        
        PreparedStatement pstmt = null;
        try {

            System.out.println("연결성공");


            String sql = "insert INTO order_r VALUES(NOTICE_IDX_SEQ.NEXTVAL,?,?,?,?)";
//            System.out.println(member.getMember_idx()+" "+ member.getId());

            pstmt =conn.prepareStatement(sql);

//            pstmt.setInt(1,order.getOrder_idx());
            pstmt.setString(1,order.getOrder_date());
            pstmt.setString(2,order.getOrder_date());
            pstmt.setInt(3,1);
            pstmt.setInt(4,order.getOrder_price());

            boolean result = pstmt.execute();
//            pstmt.executeUpdate();
            System.out.println("Result : "+result);
            conn.close();
            pstmt.close();
            strat();
        } catch (SQLException e) {
            System.out.println("DB 연결 실패 무언가 잘못됬다.. 드라이버 연결 정보 오류");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("별도의 사유로 연결 실패");
            e.printStackTrace();

        }


    }


    @Override
    public void cancle(Order order) throws SQLException {
        PreparedStatement pstmt = null;
        try {

            System.out.println("연결성공");
            Scanner sc = new Scanner(System.in);
            System.out.println("없애고 싶은 번호");
            int del_num = sc.nextInt();
            String sql = "delete from order_r where order_idx=?";
//            System.out.println(member.getMember_idx()+" "+ member.getId());
            pstmt =conn.prepareStatement(sql);

            pstmt.setInt(1,del_num);

            pstmt.executeUpdate();

            conn.close();
            pstmt.close();
            strat();

        } catch (SQLException e) {
            System.out.println("DB 연결 실패 무언가 잘못됬다.. 드라이버 연결 정보 오류");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("별도의 사유로 연결 실패");
            e.printStackTrace();

        }

    }


}
