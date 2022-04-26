package order.controller;

import controller.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import order.entity.Order;
import order.service.OrderServiceImpl;
import order.view.OrderMenuImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderController {
    static private final String SETCLIENT = "\n" + "DATA_SET";
    static private OrderServiceImpl orderService = new OrderServiceImpl();
    static private OrderMenuImpl orderMenu = new OrderMenuImpl();
    private Order order = new Order();
    private Member member = new Member();
    private PrintWriter pw;
    private BufferedReader br;

    public void reserveList(){
        List<Order> orders = orderService.orderCheck();
        StringBuilder sb = new StringBuilder();
        for (Order order1: orders) {
            sb.append(orderMenu.showResevreList(order1));
            sb.append("\n");
        }
        pw.println(sb);
        pw.flush();
    }
    public void reserveInsert(Member member) throws IOException {
        StringBuilder sb;
        int step=1;
        String line;
        boolean insert = false;
        while (!insert){
            sb=orderMenu.reserveInsert(step);
            sb.append(SETCLIENT);
            pw.println(sb);
            pw.flush();
            line = br.readLine();
            switch (step){
                case 1:
                    order.setOrder_date(line);
                    step++;
                    break;
                case 2:
                    order.setOrder_price(Integer.parseInt(line));
                    step++;
                    orderService.orderSave(member,order);
                    sb=orderMenu.reserveInsert(step);
                    pw.println(sb);
                    pw.flush();
                    insert = true;
                    if (insert){
                        return;
                    }
                    break;
                case 3:

                    break;
            }
        }
//        orderService.orderSave(member);
    }
    public void  reserveDelete() throws IOException{
        StringBuilder sb;
        int step=1;
        String line;
        sb=orderMenu.reserveDelete(step);
        sb.append(SETCLIENT);
        pw.println(sb);
        pw.flush();
        line = br.readLine();
        boolean isDelete = orderService.orderdelete(Integer.parseInt(line));
        if (isDelete){
            step=2;
            sb=orderMenu.reserveDelete(step);
//            sb.append(SETCLIENT);
            pw.println(sb);
            pw.flush();
        }
    }
}
