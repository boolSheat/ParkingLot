package model;

import enums.VehicleType;

import java.sql.Timestamp;
import java.time.Instant;

public class Ticket {
    private Instant issuedAt;
    private VehicleType vehicleType;
    private String vehicleId;
    private Instant paidAt;
    private double paidAmount;
    private ParkingSpotLocation parkingSpotLocation;

    public Ticket(Instant issuedAt, VehicleType vehicleType, String vehicleId, ParkingSpotLocation parkingSpotLocation) {
        this.issuedAt = issuedAt;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.parkingSpotLocation = parkingSpotLocation;
    }

    public void setPaidAt(Instant paidAt) {
        this.paidAt = paidAt;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public ParkingSpotLocation getParkingSpotLocation() {
        return parkingSpotLocation;
    }

    public void setParkingSpotLocation(ParkingSpotLocation parkingSpotLocation) {
        this.parkingSpotLocation = parkingSpotLocation;
    }

    public Instant getPaidAt() {
        return paidAt;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}
