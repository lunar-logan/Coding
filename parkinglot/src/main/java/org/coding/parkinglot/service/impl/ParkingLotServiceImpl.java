package org.coding.parkinglot.service.impl;

import org.coding.parkinglot.dao.ParkingLotDao;
import org.coding.parkinglot.domain.*;
import org.coding.parkinglot.service.BookingService;
import org.coding.parkinglot.service.ParkingFloorService;
import org.coding.parkinglot.service.ParkingLotService;
import org.coding.parkinglot.service.SlotService;

import java.awt.print.Book;
import java.util.*;

public class ParkingLotServiceImpl implements ParkingLotService {
    private final ParkingLotDao parkingLotDao;
    private final ParkingFloorService parkingFloorService;
    private final SlotService slotService;
    private final BookingService bookingService;

    public ParkingLotServiceImpl(ParkingLotDao parkingLotDao, ParkingFloorService parkingFloorService, SlotService slotService, BookingService bookingService) {
        this.parkingLotDao = Objects.requireNonNull(parkingLotDao);
        this.parkingFloorService = Objects.requireNonNull(parkingFloorService);
        this.slotService = Objects.requireNonNull(slotService);
        this.bookingService = Objects.requireNonNull(bookingService);
    }

    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        parkingLot = parkingLotDao.save(parkingLot);
        List<ParkingFloor> floors = parkingLot.getFloors();
        if (floors != null) {
            for (ParkingFloor floor : floors) {
                floor.setLot(parkingLot);
                parkingFloorService.save(floor);
            }
        }
        return parkingLot;
    }

    @Override
    public Optional<ParkingLot> getById(int id) {
        return parkingLotDao.findById(id);
    }

    @Override
    public void addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor) {
        Objects.requireNonNull(parkingLot);
        Objects.requireNonNull(parkingFloor);

        addSlotsToFloor(parkingFloor);
        addFloorToParkingLot(parkingLot, parkingFloor);
        parkingLotDao.save(parkingLot);
    }

    private void addFloorToParkingLot(ParkingLot parkingLot, ParkingFloor parkingFloor) {
        List<ParkingFloor> floors = parkingLot.getFloors();
        if (floors == null) {
            floors = new ArrayList<>();
            parkingLot.setFloors(floors);
        }
        floors.add(parkingFloor);
    }

    private void addSlotsToFloor(ParkingFloor parkingFloor) {
        final List<Slot> slots = parkingFloor.getSlots();
        if (slots != null && !slots.isEmpty()) {
            parkingFloorService.addSlots(parkingFloor, slots);
        }
    }

    @Override
    public void addParkingFloors(ParkingLot parkingLot, Collection<ParkingFloor> parkingFloors) {
        Objects.requireNonNull(parkingLot);
        Objects.requireNonNull(parkingFloors);

        for (ParkingFloor parkingFloor : parkingFloors) {
            addParkingFloor(parkingLot, parkingFloor);
        }
    }

    @Override
    public Optional<Booking> book(ParkingLot parkingLot, Vehicle vehicle) {
        return slotService.getFreeSlot(parkingLot.getId().get())
                .map(slot -> slotService.book(slot, vehicle));
    }

    @Override
    public Booking free(Booking booking) {
        if (booking == null) {
            throw new NullPointerException("Booking must not be null");
        }
        if (booking.getId().isEmpty()) {
            throw new IllegalArgumentException("Booking with no ID");
        }

        return markBookingInactive(booking);
    }

    private Booking markBookingInactive(Booking booking) {
        booking.setActive(false);
        return bookingService.save(booking);
    }
}
