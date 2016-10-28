package asigurari.data.model;


public class Vehicle {
    private long identificationNo;
    private String registrationNo;
    private String type;
    private String vehicleModel;
    private int cylinders;
    private int kw;
    private int seats;


    Claim claim;
    Policy policy;

    public long getIdentificationNo() {
        return identificationNo;
    }

    public void setIdentificationNo(long identificationNo) {
        this.identificationNo = identificationNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "identificationNo=" + identificationNo +
                ", registrationNo='" + registrationNo + '\'' +
                ", type='" + type + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", cylinders=" + cylinders +
                ", kw=" + kw +
                ", seats=" + seats +
                '}';
    }
}
