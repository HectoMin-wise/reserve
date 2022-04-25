package order.dto;

import lombok.Getter;
import lombok.Setter;
import order.service.OrderService;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private List<OrderService> OR;
    private OrderService Order;

}
