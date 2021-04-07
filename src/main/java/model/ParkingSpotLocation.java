package model;

public class ParkingSpotLocation {
    private int floorId;
    private int spotId;

    public ParkingSpotLocation(int floorId, int spotId) {
        this.floorId = floorId;
        this.spotId = spotId;
    }

    public int getFloorId() {
        return floorId;
    }

    public int getSpotId() {
        return spotId;
    }
}
