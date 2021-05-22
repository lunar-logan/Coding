package org.coding.parkinglot;

import org.coding.parkinglot.dao.BookingDao;
import org.coding.parkinglot.dao.ParkingFloorDao;
import org.coding.parkinglot.dao.ParkingLotDao;
import org.coding.parkinglot.dao.SlotDao;
import org.coding.parkinglot.dao.impl.BookingDaoImpl;
import org.coding.parkinglot.dao.impl.ParkingFloorDaoImpl;
import org.coding.parkinglot.dao.impl.ParkingLotDaoImpl;
import org.coding.parkinglot.dao.impl.SlotDaoImpl;
import org.coding.parkinglot.domain.*;
import org.coding.parkinglot.service.BookingService;
import org.coding.parkinglot.service.ParkingFloorService;
import org.coding.parkinglot.service.ParkingLotService;
import org.coding.parkinglot.service.SlotService;
import org.coding.parkinglot.service.impl.BookingServiceImpl;
import org.coding.parkinglot.service.impl.ParkingFloorServiceImpl;
import org.coding.parkinglot.service.impl.ParkingLotServiceImpl;
import org.coding.parkinglot.service.impl.SlotServiceImpl;

import java.util.List;
import java.util.Optional;

public class ParkingLotApplication {
    public static void main(String[] args) {
        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl();
        SlotDao slotDao = new SlotDaoImpl();
        ParkingFloorDao parkingFloorDao = new ParkingFloorDaoImpl();
        BookingDao bookingDao = new BookingDaoImpl();

        BookingService bookingService = new BookingServiceImpl(bookingDao);

        SlotService slotService = new SlotServiceImpl(slotDao, bookingService);
        ParkingFloorService parkingFloorService = new ParkingFloorServiceImpl(parkingFloorDao, slotService);
        ParkingLotService service = new ParkingLotServiceImpl(parkingLotDao, parkingFloorService, slotService, bookingService);

        ParkingLot lot = service.save(new ParkingLot(null, List.of()));
        ParkingFloor parkingFloor = new ParkingFloor(null, lot, List.of());
        Slot s1 = new Slot(null, parkingFloor, 1);
        Slot s2 = new Slot(null, parkingFloor, 1);
        parkingFloor.setSlots(List.of(s1, s2));
        parkingFloor.setLot(lot);
        lot.setFloors(List.of(parkingFloor));


        service.save(lot);
        System.out.println(service.getById(1));

        Optional<Booking> car = service.book(lot, new Vehicle("1234", "Car"));
        System.out.println(car);
        System.out.println(service.book(lot, new Vehicle("1234", "Car")));
        System.out.println(service.book(lot, new Vehicle("1234", "Car")));

        System.out.println(service.free(car.get()));
        System.out.println(service.book(lot, new Vehicle("1234", "Car")));
    }
}
