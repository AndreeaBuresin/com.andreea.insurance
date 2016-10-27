package asigurari.data.model;

import java.time.LocalDate;


public class Claim {

    private int id;
    private String type;
    private double damages;
    private double moralDamages;
    private double losses;
    private LocalDate registrationDate;

    private Policy policy;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDamages() {
        return damages;
    }

    public void setDamages(double damages) {
        this.damages = damages;
    }

    public double getMoralDamages() {
        return moralDamages;
    }

    public void setMoralDamages(double moralDamages) {
        this.moralDamages = moralDamages;
    }

    public double getLosses() {
        return losses;
    }

    public void setLosses(double losses) {
        this.losses = losses;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Claim)) return false;

        Claim claim = (Claim) o;

        if (id != claim.id) return false;
        if (Double.compare(claim.damages, damages) != 0) return false;
        if (Double.compare(claim.moralDamages, moralDamages) != 0) return false;
        if (Double.compare(claim.losses, losses) != 0) return false;
        if (type != null ? !type.equals(claim.type) : claim.type != null) return false;
        return registrationDate != null ? registrationDate.equals(claim.registrationDate) : claim.registrationDate == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(damages);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(moralDamages);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(losses);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", damages=" + damages +
                ", moralDamages=" + moralDamages +
                ", losses=" + losses +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
