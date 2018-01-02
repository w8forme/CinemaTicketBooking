package com.booking.service;

import com.booking.model.Order;

import java.util.List;

/**
 * Created by Pavel Holinko on 26.12.2017.
 */
public interface OrderService {

    void deleteAllOrders();
    void makeOrder(Order order);
    List<Order> getAllOrders();
}
