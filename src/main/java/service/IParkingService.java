package service;

import Exceptions.ParkingLotFullException;
import model.ParkingFloor;
import model.Ticket;
import model.Vehicle;

public interface IParkingService {
    public Ticket issueTicket(Vehicle vehicle) throws ParkingLotFullException;
    public double payTicketFee(Ticket ticket);
    public void addParkingFloor(ParkingFloor parkingFloor);
}
