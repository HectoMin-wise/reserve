package order.view;

import order.entity.Order;

public class OrderMenuImpl implements OrderMenu {

    @Override
    public StringBuilder showResevreList(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("예약 번호: " + order.getOrder_idx());
        sb.append(" 예약 날짜: " + order.getOrder_date());
        sb.append(" 가격: " + order.getOrder_price());
        return sb;
    }

    @Override
    public StringBuilder reseveInsert(int step) {
        StringBuilder sb = new StringBuilder();
        switch (step) {
            case 1:
                sb.append("예약날짜를 입력해 주세요 ex) 20/12/25");
                return sb;
            case 2:
                sb.append("가격을 입력해주세요");
                return sb;
        }
        return sb;
    }


        @Override
        public StringBuilder reseveCancle () {
            return null;
        }
    }