package model;

import enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    String name;
    List<ParkingFloor> parkingFloors;

    public ParkingLot(String name) {
        this.name = name;
        this.parkingFloors = new ArrayList<>();
    }

    public boolean isFull(VehicleType vehicleType) {
        return !parkingFloors.stream().anyMatch(parkingFloor -> !parkingFloor.isFull(vehicleType));
    }

    public ParkingSpotLocation bookParkingSpotLocation(VehicleType vehicleType){
        ParkingFloor floor = parkingFloors.stream().filter(parkingFloor -> !parkingFloor.isFull(vehicleType)).findFirst().get();
        int spotId = floor.bookParkingSpot(vehicleType);
        return new ParkingSpotLocation(floor.getFloorNumber(), spotId);
    }

    public void addParkingFloor(ParkingFloor newParkingFloor) {
        Optional<ParkingFloor> optionalParkingFloor = parkingFloors.stream().filter(parkingFloor -> parkingFloor.getFloorNumber() == newParkingFloor.getFloorNumber()).findAny();
        if(optionalParkingFloor.isPresent()) {
            System.out.println("Parking floor with id " + newParkingFloor.getFloorNumber() + " already present");
            return;
        }
        parkingFloors.add(newParkingFloor);
        System.out.println("Parking floor added");
    }
    public void removeParkingFloor(int floorId) {
        Optional<ParkingFloor> optionalParkingFloor = parkingFloors.stream().filter(parkingFloor -> parkingFloor.getFloorNumber() == floorId).findAny();
        if(optionalParkingFloor.isPresent()) {
            parkingFloors.remove(optionalParkingFloor.get());
            System.out.println("Parking floor " + floorId + " removed");
        }
        else {
            System.out.println("Parking floor with id " + floorId + " not found");
        }
    }
    public void freeParkingSpot(ParkingSpotLocation parkingSpotLocation) {
        ParkingFloor floor = parkingFloors.stream().filter(parkingFloor -> parkingFloor.getFloorNumber()==parkingSpotLocation.getFloorId()).findFirst().get();
        floor.freeParkingSpot(parkingSpotLocation.getSpotId());
    }
}
