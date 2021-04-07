package model;

import enums.VehicleType;

public class Vehicle {
    private String vehicleId;
    private VehicleType vehicleType;
    private Ticket ticket;

    public Vehicle(String vehicleId, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
