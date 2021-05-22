package org.coding.parkinglot.service;

import org.coding.parkinglot.domain.Booking;
import org.coding.parkinglot.domain.ParkingFloor;
import org.coding.parkinglot.domain.ParkingLot;
import org.coding.parkinglot.domain.Vehicle;

import java.util.Collection;
import java.util.Optional;

public interface ParkingLotService {
    ParkingLot save(ParkingLot parkingLot);

    Optional<ParkingLot> getById(int id);

    void addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor);

    void addParkingFloors(ParkingLot parkingLot, Collection<ParkingFloor> parkingFloor);

    Optional<Booking> book(ParkingLot parkingLot, Vehicle vehicle);

    Booking free(Booking booking);
}
