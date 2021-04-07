package service;

import Exceptions.ParkingLotFullException;
import enums.VehicleType;
import model.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class ParkingServiceImpl implements IParkingService{

    private ParkingLot parkingLot;

    public ParkingServiceImpl(){
        this.parkingLot = new ParkingLot("Bengaluru Parking");
    }

    @Override
    public Ticket issueTicket(Vehicle vehicle) throws ParkingLotFullException {
        if(isSpotAvailable(vehicle.getVehicleType())) {
            ParkingSpotLocation parkingSpotLocation = parkingLot.bookParkingSpotLocation(vehicle.getVehicleType());
            Ticket ticket = new Ticket(Instant.now(), vehicle.getVehicleType(), vehicle.getVehicleId(), parkingSpotLocation);
            System.out.println("Ticket issued to: " + vehicle.getVehicleId()+ ", vehicleType: " + vehicle.getVehicleType()+ ", floor: " + ticket.getParkingSpotLocation().getFloorId()+ ", spotId: " + ticket.getParkingSpotLocation().getSpotId());
            return ticket;
        }
        throw new ParkingLotFullException();
    }

    @Override
    public double payTicketFee(Ticket ticket) {
        int hours = (int) ChronoUnit.HOURS.between(Instant.now(),ticket.getIssuedAt());
        freeParkingSpot(ticket.getParkingSpotLocation());
        double fee = ParkingFee.getTicketFee(hours);
        System.out.println("Ticket fee paid: " + fee + ", floor: " + ticket.getParkingSpotLocation().getFloorId()+ ", spotId: " + ticket.getParkingSpotLocation().getSpotId() + " is free");
        return ParkingFee.getTicketFee(hours);
    }

    private void freeParkingSpot(ParkingSpotLocation parkingSpotLocation) {
        parkingLot.freeParkingSpot(parkingSpotLocation);
    }

    @Override
    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingLot.addParkingFloor(parkingFloor);
    }

    boolean isSpotAvailable(VehicleType vehicleType) {
        return !parkingLot.isFull(vehicleType);
    }
}
