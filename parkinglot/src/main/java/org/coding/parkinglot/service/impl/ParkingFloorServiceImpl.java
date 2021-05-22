package org.coding.parkinglot.service.impl;

import org.coding.parkinglot.dao.ParkingFloorDao;
import org.coding.parkinglot.dao.SlotDao;
import org.coding.parkinglot.domain.ParkingFloor;
import org.coding.parkinglot.domain.Slot;
import org.coding.parkinglot.service.ParkingFloorService;
import org.coding.parkinglot.service.SlotService;

import java.util.*;

public class ParkingFloorServiceImpl implements ParkingFloorService {
    private final ParkingFloorDao parkingFloorDao;
    private final SlotService slotService;

    public ParkingFloorServiceImpl(ParkingFloorDao parkingFloorDao, SlotService slotService) {
        this.parkingFloorDao = Objects.requireNonNull(parkingFloorDao);
        this.slotService = Objects.requireNonNull(slotService);
    }

    @Override
    public ParkingFloor save(ParkingFloor parkingFloor) {
        parkingFloor = parkingFloorDao.save(parkingFloor);

        List<Slot> slots = parkingFloor.getSlots();
        if (slots != null) {
            for (Slot slot : slots) {
                slot.setFloor(parkingFloor);
                slotService.save(slot);
            }
        }
        return parkingFloor;
    }

    @Override
    public Optional<ParkingFloor> getById(int id) {
        return parkingFloorDao.findById(id);
    }

    @Override
    public void addSlot(ParkingFloor parkingFloor, Slot slot) {
        Objects.requireNonNull(parkingFloor);
        Objects.requireNonNull(slot);
        final Slot savedSlot = slotService.save(slot);
        addSlotToParkingFloor(parkingFloor, savedSlot);
        save(parkingFloor);
    }

    private void addSlotToParkingFloor(ParkingFloor parkingFloor, Slot slot) {
        List<Slot> slots = parkingFloor.getSlots();
        if (slot == null) {
            slots = new ArrayList<>();
            parkingFloor.setSlots(slots);
        }
        slots.add(slot);
    }

    @Override
    public void addSlots(ParkingFloor parkingFloor, Collection<Slot> slots) {
        Objects.requireNonNull(parkingFloor);
        Objects.requireNonNull(slots);
        for (Slot slot : slots) {
            addSlot(parkingFloor, slot);
        }
    }
}
