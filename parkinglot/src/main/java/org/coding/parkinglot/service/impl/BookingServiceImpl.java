package org.coding.parkinglot.service.impl;

import org.coding.parkinglot.dao.BookingDao;
import org.coding.parkinglot.domain.Booking;
import org.coding.parkinglot.service.BookingService;

import java.awt.print.Book;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;

    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = Objects.requireNonNull(bookingDao);
    }

    @Override
    public Booking save(Booking booking) {
        return bookingDao.save(booking);
    }

    @Override
    public Optional<Booking> getById(Integer id) {
        return bookingDao.findById(id);
    }

    @Override
    public List<Booking> getAllActiveBookings() {
        return bookingDao.findAll().stream()
                .filter(Booking::isActive)
                .collect(Collectors.toList());
    }
}
