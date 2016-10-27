package asigurari.data.model;

/**
 * Created by buresina on 26/10/2016.
 */
public class Policy {
    int id;
    String type;
    double amount;
    double discount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;

        Policy policy = (Policy) o;

        if (id != policy.id) return false;
        if (Double.compare(policy.amount, amount) != 0) return false;
        if (Double.compare(policy.discount, discount) != 0) return false;
        return type != null ? type.equals(policy.type) : policy.type == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}
