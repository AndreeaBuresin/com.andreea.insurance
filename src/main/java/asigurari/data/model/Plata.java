package asigurari.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plata")
public class Plata implements Serializable {

    @Id
    @Column(name = "idplati", length = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "salar")
    double salar;

    @Column(name = "comisionS")
    double comisionS;

    @Column(name = "comision")
    double comision;

    @JoinColumn(foreignKey = @ForeignKey(name = "despagubireId"))
    String despagubire;
    @JoinColumn(foreignKey = @ForeignKey(name = "persoanaPlatitaId"))
    String persoana;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalar() {
        return salar;
    }

    public void setSalar(double salar) {
        this.salar = salar;
    }

    public double getComisionS() {
        return comisionS;
    }

    public void setComisionS(double comisionS) {
        this.comisionS = comisionS;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public String getDespagubire() {
        return despagubire;
    }

    public void setDespagubire(String despagubire) {
        this.despagubire = despagubire;
    }

    public String getPersoana() {
        return persoana;
    }

    public void setPersoana(String persoana) {
        this.persoana = persoana;
    }

    @Override
    public String toString() {
        return "Plata{" +
                "id=" + id +
                ", salar=" + salar +
                ", comisionS=" + comisionS +
                ", comision=" + comision +
                ", despagubire='" + despagubire + '\'' +
                ", persoana='" + persoana + '\'' +
                '}';
    }
}
