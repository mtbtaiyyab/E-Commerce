package com.ecommerce.service;

import com.ecommerce.dto.OrderLineItemDTO;
import com.ecommerce.dto.OrderRequest;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderLineItem;
import com.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItemList =  orderRequest.getOrderLineItemDTOList()
                .stream()
                .map(this::mapToDto).toList();
        order.setOrderLineItems(orderLineItemList);
        log.debug("OrderService :: placeOrder :: orderLineItemList :: "+ orderLineItemList);
        orderRepository.save(order);
    }

    private OrderLineItem mapToDto(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItemDTO.getPrice());
        orderLineItem.setQuantity(orderLineItemDTO.getQuantity());
        orderLineItem.setSkuCode(orderLineItemDTO.getSkuCode());
        log.debug("OrderService :: mapToDto :: orderLineItem :: "+ orderLineItem);
        return orderLineItem;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
