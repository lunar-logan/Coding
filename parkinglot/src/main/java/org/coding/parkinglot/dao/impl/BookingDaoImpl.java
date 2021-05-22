package org.coding.parkinglot.dao.impl;

import org.coding.parkinglot.dao.AbstractDao;
import org.coding.parkinglot.dao.BookingDao;
import org.coding.parkinglot.domain.Booking;
import org.coding.parkinglot.domain.ParkingFloor;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingDaoImpl extends AbstractDao<Booking, Integer> implements BookingDao {
    private static final AtomicInteger ID_CTR = new AtomicInteger();


    public BookingDaoImpl() {
        super(booking -> booking.getId().orElse(null), BookingDaoImpl::setBookingId, ID_CTR::incrementAndGet);
    }

    private static Booking setBookingId(Booking booking, Integer id) {
        booking.setId(id);
        return booking;
    }
}
