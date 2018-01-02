package com.booking.controller;

import com.booking.model.Seat;
import com.booking.model.SeatsDTO;
import com.booking.service.OrderService;
import com.booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
public class SeatController {

    private final SeatService seatService;
    private final OrderService orderService;

    @Autowired
    public SeatController(SeatService seatService, OrderService orderService) {
        this.seatService = seatService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public String getAllSeats(Model model) {
        List<Seat> seats = seatService.getAllSeats();
        seats.sort(Comparator.comparing(Seat::getId));
        model.addAttribute("seats", seats);
        return "booking";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String resetReservation(Model model) {
        List<Seat> seats = seatService.getAllSeats();
        model.addAttribute("seats", seats);
        seats.stream()
                .filter(Seat::isReserved)
                .forEach(seat -> {
                    seat.setReserved(false);
                    seat.setOrder(null);
                });
        seatService.updateSeats(seats);
        orderService.deleteAllOrders();
        return "redirect:tickets";
    }
}
