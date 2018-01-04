package com.booking.service.impl;

import com.booking.model.Order;
import com.booking.model.Seat;
import com.booking.repository.OrderRepository;
import com.booking.repository.SeatRepository;
import com.booking.service.OrderService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private OrderRepository orderRepository;

    private Order orderForTest;

    private Seat seatForTest;

    @Test
    public void deleteAllOrders() {
        orderRepository.save(orderForTest);
        assertThat(orderRepository.getOne(orderForTest.getId())).isNotNull();
        orderRepository.deleteAll();
        assertThat(orderRepository.findAll()).isEmpty();
    }

    @Test
    public void makeOrder() {
        orderRepository.save(orderForTest);
        assertThat(orderRepository.getOne(orderForTest.getId())).isNotNull();
    }

    @Test
    public void getAllOrders() {
        orderRepository.save(orderForTest);
        List<Order> orders = orderService.getAllOrders();
        assertThat(orders.isEmpty()).isFalse();
    }

    @Before
    public void setUp() throws Exception {
        orderForTest = new Order();
        seatForTest = seatRepository.findOne(1L);
        orderForTest.setEmail("test@example.com");
        orderForTest.setName("Alex");
        orderForTest.setTotal(seatForTest.getPrice());
        List<Seat> seats = new ArrayList<>();
        seats.add(seatForTest);
        orderForTest.setSeatsList(seats);
    }

    @After
    public void tearDown() throws Exception {
        orderRepository.deleteAll();
    }
}