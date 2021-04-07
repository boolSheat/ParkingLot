package model;

import enums.ParkingSpotState;
import enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ArrayList<>();
    }

    public int bookParkingSpot(VehicleType vehicleType) {
        ParkingSpot spot = parkingSpots.stream().filter(parkingSpot -> parkingSpot.isEmpty()&&parkingSpot.getVehicleType().equals(vehicleType)).findFirst().get();
        spot.setParkingSpotState(ParkingSpotState.OCCUPIED);
        return spot.getSpotId();
    }

    public boolean isFull(VehicleType vehicleType) {
        return !parkingSpots.stream().anyMatch(parkingSpot -> parkingSpot.getVehicleType().equals(vehicleType) && parkingSpot.isEmpty());
    }
    public void addParkingSpot(ParkingSpot newParkingSpot) {
        Optional<ParkingSpot> optionalParkingSpot = parkingSpots.stream().filter(parkingSpot -> parkingSpot.getSpotId() == newParkingSpot.getSpotId()).findAny();
        if(optionalParkingSpot.isPresent()) {
            System.out.println("Parking spot with id " + newParkingSpot.getSpotId() + " already present");
            return;
        }
        parkingSpots.add(newParkingSpot);
        System.out.println("Parking spot added");
    }
    public void removeParkingSpot(int spotId) {
        Optional<ParkingSpot> optionalParkingSpot = parkingSpots.stream().filter(parkingSpot -> parkingSpot.getSpotId() == spotId).findAny();
        if(optionalParkingSpot.isPresent()) {
            parkingSpots.remove(optionalParkingSpot.get());
            System.out.println("Parking spot " + spotId + " removed");
        }
        else {
            System.out.println("Parking spot with id " + spotId + " not found");
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void freeParkingSpot(int spotId) {
        parkingSpots.stream().filter(parkingSpot -> parkingSpot.getSpotId()==spotId).findFirst().get().setParkingSpotState(ParkingSpotState.AVAILABLE);
    }
}
