package org.coding.parkinglot.dao.impl;

import org.coding.parkinglot.dao.AbstractDao;
import org.coding.parkinglot.dao.ParkingLotDao;
import org.coding.parkinglot.domain.ParkingLot;
import org.coding.parkinglot.domain.Slot;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ParkingLotDaoImpl extends AbstractDao<ParkingLot, Integer> implements ParkingLotDao {
    private static final AtomicInteger ID_CTR = new AtomicInteger();

    public ParkingLotDaoImpl() {
        super(lot -> lot.getId().orElse(null), ParkingLotDaoImpl::setParkingLotId, ID_CTR::incrementAndGet);
    }

    private static ParkingLot setParkingLotId(ParkingLot lot, Integer id) {
        lot.setId(id);
        return lot;
    }
}
