package com.booking.controller;

import com.booking.model.Order;
import com.booking.model.Seat;
import com.booking.service.OrderService;
import com.booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class OrderController {

    private final SeatService seatService;
    private final OrderService orderService;

    @Autowired
    public OrderController(SeatService seatService, OrderService orderService) {
        this.seatService = seatService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST )
    public String updateSeats(@RequestParam(value = "seat") List<Long> seatsId,
                              @RequestParam(value = "email") String email,
                              @RequestParam(value = "name") String name) {

        Collections.sort(seatsId);
        List<Seat> seats = seatService.getSeatsByIds(seatsId);
        Order order = new Order();
        Integer sum = seats.stream().mapToInt(Seat::getPrice).sum();
        seats.forEach(seat -> seat.setOrder(order));
        seats.forEach(seat -> seat.setReserved(true));
        order.setEmail(email);
        order.setName(name);
        order.setTotal(sum);
        order.setSeatsList(seats);
        orderService.makeOrder(order);
        System.out.println(seats);
        return "redirect:tickets";
    }
}
