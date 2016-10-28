package asigurari.data.model;

import java.time.LocalDate;

/**
 * Created by buresina on 26/10/2016.
 */
public class Policy {
    int id;
    String type;
    double amount;
    double discount;
    LocalDate startDate;
    LocalDate endDate;

    Person personCustomer;
    Person personEmployee;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", personCustomer=" + personCustomer +
                ", personEmployee=" + personEmployee +
                '}';
    }
}
