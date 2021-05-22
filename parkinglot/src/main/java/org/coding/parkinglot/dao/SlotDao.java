package org.coding.parkinglot.dao;

import org.coding.parkinglot.domain.Slot;

import java.util.List;

public interface SlotDao extends CrudOperations<Slot, Integer> {
    List<Slot> findAllByParkingFloorId(int parkingFloorId);

    List<Slot> findAllByParkingLotId(int parkingLotId);
}
