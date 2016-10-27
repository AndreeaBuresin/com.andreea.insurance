package asigurari.data.model;


public class Vehicle {
    private int id;
    private String type;
    private String vehicleModel;
    private int cylinders;
    private int kw;
    private int seats;
    private long identificationNo;
    private String registrationNo;

//    claimsID;
//    policyId;


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

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (id != vehicle.id) return false;
        if (cylinders != vehicle.cylinders) return false;
        if (kw != vehicle.kw) return false;
        if (seats != vehicle.seats) return false;
        if (identificationNo != vehicle.identificationNo) return false;
        if (type != null ? !type.equals(vehicle.type) : vehicle.type != null) return false;
        if (vehicleModel != null ? !vehicleModel.equals(vehicle.vehicleModel) : vehicle.vehicleModel != null)
            return false;
        return registrationNo != null ? registrationNo.equals(vehicle.registrationNo) : vehicle.registrationNo == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (vehicleModel != null ? vehicleModel.hashCode() : 0);
        result = 31 * result + cylinders;
        result = 31 * result + kw;
        result = 31 * result + seats;
        result = 31 * result + (int) (identificationNo ^ (identificationNo >>> 32));
        result = 31 * result + (registrationNo != null ? registrationNo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", cylinders=" + cylinders +
                ", kw=" + kw +
                ", seats=" + seats +
                ", identificationNo=" + identificationNo +
                ", registrationNo='" + registrationNo + '\'' +
                '}';
    }
}
