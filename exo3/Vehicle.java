package exo3;

public class Vehicle {
    private String vehicleId;
    private String vehicleMake;
    private String vehicleModel;
    private int vehicleYear;
    private String vehicleType;

    public Vehicle(String vehicleId, String vehicleMake, String vehicleModel,
                   int vehicleYear, String vehicleType) {
        if (vehicleYear < 1990 || vehicleYear > 2025)
            throw new IllegalArgumentException("Invalid vehicle year.");
        this.vehicleId = vehicleId;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() { return vehicleId; }
    public String getVehicleType() { return vehicleType; }
    public int getVehicleYear() { return vehicleYear; }
    public String toString() {
        return vehicleMake + " " + vehicleModel + " (" + vehicleYear + ") - " + vehicleType;
    }
}

