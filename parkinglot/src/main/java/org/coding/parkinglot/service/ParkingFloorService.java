package org.coding.parkinglot.service;

import org.coding.parkinglot.domain.ParkingFloor;
import org.coding.parkinglot.domain.Slot;

import java.util.Collection;
import java.util.Optional;

public interface ParkingFloorService {
    ParkingFloor save(ParkingFloor parkingFloor);
    Optional<ParkingFloor> getById(int id);
    void addSlot(ParkingFloor parkingFloor, Slot slot);
    void addSlots(ParkingFloor parkingFloor, Collection<Slot> slots);
}
