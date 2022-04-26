package order.view;

import order.entity.Order;

public interface OrderMenu {
    StringBuilder showResevreList(Order order);
    StringBuilder reseveInsert(int step);
    StringBuilder reseveCancle();
}
