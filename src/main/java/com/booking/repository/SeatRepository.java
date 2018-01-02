package com.booking.repository;

import com.booking.model.Seat;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findAllByReserved(boolean reserved);
    List<Seat> findAllByIdIn(List<Long> ids);
}
