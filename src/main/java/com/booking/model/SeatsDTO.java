package com.booking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SeatsDTO implements Serializable {

    private String email;
    private String name;
    private List<Seat> checkedSeats;

    public List<Seat> getCheckedSeats() {
        return checkedSeats;
    }

    public void setCheckedSeats(List<Seat> checkedSeats) {
        this.checkedSeats = checkedSeats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
