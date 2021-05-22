package org.coding.parkinglot.dao.impl;

import org.coding.parkinglot.dao.AbstractDao;
import org.coding.parkinglot.dao.SlotDao;
import org.coding.parkinglot.domain.Slot;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

public class SlotDaoImpl extends AbstractDao<Slot, Integer> implements SlotDao {
    private static final AtomicInteger ID_CTR = new AtomicInteger();
    private final Map<Integer, List<Slot>> parkingFloorIdMap = new ConcurrentHashMap<>();
    private final Map<Integer, List<Slot>> parkingLotIdMap = new ConcurrentHashMap<>();

    public SlotDaoImpl() {
        super(slot -> slot.getId().orElse(null), SlotDaoImpl::setSlotId, ID_CTR::incrementAndGet);
    }

    private static Slot setSlotId(Slot slot, Integer id) {
        slot.setId(id);
        return slot;
    }

    @Override
    public Slot save(Slot entity) {
        Slot slot = super.save(entity);
        int parkingFloorId = slot.getFloor().getId().get();
        parkingFloorIdMap.computeIfAbsent(parkingFloorId, it -> new ArrayList<>()).add(slot);

        int parkingLotId = slot.getFloor().getLot().getId().get();
        parkingLotIdMap.computeIfAbsent(parkingLotId, it -> new ArrayList<>()).add(slot);

        return slot;
    }

    @Override
    public List<Slot> findAllByParkingFloorId(int parkingFloorId) {
        return parkingFloorIdMap.get(parkingFloorId);
    }

    @Override
    public List<Slot> findAllByParkingLotId(int parkingLotId) {
        return parkingLotIdMap.get(parkingLotId);
    }
}
