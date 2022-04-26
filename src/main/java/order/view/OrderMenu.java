package order.view;

import order.entity.Order;

public interface OrderMenu {
    StringBuilder showResevreList(Order order);
    StringBuilder reserveInsert(int step);
    StringBuilder reserveDelete(int step);
}
