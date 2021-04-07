package model;

import enums.ParkingSpotState;
import enums.VehicleType;

public class ParkingSpot {
    private int spotId;
    private ParkingSpotState parkingSpotState;
    private VehicleType vehicleType;

    public ParkingSpot(int spotId, VehicleType vehicleType) {
        this.spotId = spotId;
        this.vehicleType = vehicleType;
        this.parkingSpotState = ParkingSpotState.AVAILABLE;
    }

    public void setParkingSpotState(ParkingSpotState parkingSpotState) {
        this.parkingSpotState = parkingSpotState;
    }

    public int getSpotId() {
        return spotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    boolean isEmpty() {
        if(parkingSpotState.equals(ParkingSpotState.AVAILABLE)) {
            return true;
        }
        return false;
    }
}
