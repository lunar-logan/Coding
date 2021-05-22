package org.coding.parkinglot.service;

import org.coding.parkinglot.domain.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking save(Booking booking);

    Optional<Booking> getById(Integer id);

    List<Booking> getAllActiveBookings();
}
