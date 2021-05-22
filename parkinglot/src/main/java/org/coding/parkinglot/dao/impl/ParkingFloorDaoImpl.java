package org.coding.parkinglot.dao.impl;

import org.coding.parkinglot.dao.AbstractDao;
import org.coding.parkinglot.dao.ParkingFloorDao;
import org.coding.parkinglot.domain.ParkingFloor;
import org.coding.parkinglot.domain.ParkingLot;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingFloorDaoImpl extends AbstractDao<ParkingFloor, Integer> implements ParkingFloorDao {
    private static final AtomicInteger ID_CTR = new AtomicInteger();


    public ParkingFloorDaoImpl() {
        super(floor -> floor.getId().orElse(null), ParkingFloorDaoImpl::setParkingFloorId, ID_CTR::incrementAndGet);
    }

    private static ParkingFloor setParkingFloorId(ParkingFloor floor, Integer id) {
        floor.setId(id);
        return floor;
    }
}
