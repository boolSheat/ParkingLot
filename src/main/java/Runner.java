import enums.VehicleType;
import model.*;
import service.IParkingService;
import service.ParkingServiceImpl;

public class Runner {
    public static void main(String[] args) {
        IParkingService parkingService = new ParkingServiceImpl();
        ParkingFloor parkingFloor = new ParkingFloor(1);
        parkingFloor.addParkingSpot(new ParkingSpot(1, VehicleType.CAR));
        parkingFloor.addParkingSpot(new ParkingSpot(2, VehicleType.CAR));
        parkingFloor.addParkingSpot(new ParkingSpot(3, VehicleType.BIKE));
        parkingService.addParkingFloor(parkingFloor);
        Vehicle car1 = new Vehicle("KA001", VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA002", VehicleType.CAR);
        Vehicle car3 = new Vehicle("KA003", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("KA004", VehicleType.BIKE);
        Vehicle bike2 = new Vehicle("KA005", VehicleType.BIKE);
        Ticket ticket1 = parkingService.issueTicket(car1);
        parkingService.issueTicket(car2);
        parkingService.payTicketFee(ticket1);
        parkingService.issueTicket(car3);
        parkingService.issueTicket(bike1);
    }

    private static void addParkingSpot(ParkingFloor parkingFloor, int spotId, VehicleType vehicleType) {
        parkingFloor.addParkingSpot(new ParkingSpot(spotId, vehicleType));
    }
}