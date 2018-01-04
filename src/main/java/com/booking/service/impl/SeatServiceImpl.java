package com.booking.service.impl;

import com.booking.model.Seat;
import com.booking.repository.OrderRepository;
import com.booking.repository.SeatRepository;
import com.booking.service.OrderService;
import com.booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public int countIncome(boolean isReserved) {
        return seatRepository.findAllByReserved(isReserved)
                .stream()
                .mapToInt(Seat::getPrice)
                .sum();
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public List<Seat> getSeatsByIds(List<Long> ids) {
        return seatRepository.findAllByIdIn(ids);
    }

    public void updateSeats(List<Seat> seats) {
        seatRepository.save(seats);
    }

}
