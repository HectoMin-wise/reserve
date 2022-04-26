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
        orderService.orderCheck();
    }
    public void reserveInsert() throws IOException {
        StringBuilder sb;
        int step=1;
        String line;
        boolean insert = false;
        while (!insert){
            sb=orderMenu.reseveInsert(step);
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
                    break;
                case 3:
                    orderService.orderSave(member,order);
                    insert = true;
                    break;
            }
        }
//        orderService.orderSave(member);
    }
}
