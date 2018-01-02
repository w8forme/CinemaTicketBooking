package com.booking.service;

import com.booking.model.Seat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatService {

    int countIncome(boolean isReserved);
    List<Seat> getAllSeats();
    List<Seat> getSeatsByIds(List<Long> ids);
    void updateSeats(List<Seat> seats);

}
