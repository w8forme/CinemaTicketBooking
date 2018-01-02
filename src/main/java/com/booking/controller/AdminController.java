package com.booking.controller;

import com.booking.model.Order;
import com.booking.service.OrderService;
import com.booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminController {

    private final SeatService seatService;
    private final OrderService orderService;

    @Autowired
    public AdminController(SeatService seatService, OrderService orderService) {
        this.seatService = seatService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getStats(Model model) {
        List<Order> orders = orderService.getAllOrders();
        Integer totalSum = orders.stream().mapToInt(Order::getTotal).sum();
        model.addAttribute("totalSum", totalSum);
        model.addAttribute("orders", orders);
        return "admin";
    }

}
