package org.coding.parkinglot.service.impl;

import org.coding.parkinglot.dao.SlotDao;
import org.coding.parkinglot.domain.Booking;
import org.coding.parkinglot.domain.Slot;
import org.coding.parkinglot.domain.Vehicle;
import org.coding.parkinglot.service.BookingService;
import org.coding.parkinglot.service.SlotService;

import java.util.*;
import java.util.stream.Collectors;

public class SlotServiceImpl implements SlotService {
    private final SlotDao slotDao;
    private final BookingService bookingService;

    public SlotServiceImpl(SlotDao slotDao, BookingService bookingService) {
        this.slotDao = slotDao;
        this.bookingService = bookingService;
    }

    @Override
    public Slot save(Slot slot) {
        return slotDao.save(slot);
    }

    @Override
    public Optional<Slot> getById(int id) {
        return slotDao.findById(id);
    }

    @Override
    public synchronized Optional<Slot> getFreeSlot(int parkingLotId) {
        final Set<Integer> bookedSlots = getAllBookedSlots();
        return filterFirstFreeSlot(parkingLotId, bookedSlots);
    }

    private Optional<Slot> filterFirstFreeSlot(int parkingLotId, Set<Integer> bookedSlots) {
        return slotDao.findAllByParkingLotId(parkingLotId).stream()
                .filter(slot -> !bookedSlots.contains(slot.getId().get()))
                .findFirst();
    }

    private Set<Integer> getAllBookedSlots() {
        return bookingService.getAllActiveBookings()
                .stream()
                .map(Booking::getSlot)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public synchronized Booking book(Slot slot, Vehicle vehicle) {
        return bookingService.save(Booking.builder()
                .setSlot(slot.getId().get())
                .setActive(true)
                .setCreated(new Date())
                .build());
    }
}
