package asigurari.data.model;

public class HomePolicy extends Policy {
    private int id;
    private String type;
    private String address;

//    startDate;
//    endDate;
//    customerId;
//    policyId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HomePolicy)) return false;
        if (!super.equals(o)) return false;

        HomePolicy that = (HomePolicy) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HomePolicy{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
