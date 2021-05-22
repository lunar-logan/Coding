package org.coding.parkinglot.service;

import org.coding.parkinglot.domain.Booking;
import org.coding.parkinglot.domain.Slot;
import org.coding.parkinglot.domain.Vehicle;

import java.util.Optional;

public interface SlotService {
    Slot save(Slot slot);

    Optional<Slot> getById(int id);

    Optional<Slot> getFreeSlot(int parkingLotId);

    Booking book(Slot slot, Vehicle vehicle);
}
