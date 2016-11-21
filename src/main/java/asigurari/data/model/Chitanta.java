package asigurari.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "chitanta")
public class Chitanta implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "suma")
    private double suma;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "discount")
    private double discount;

    @JoinColumn(foreignKey = @ForeignKey(name = "persoanaId"))
    private String persoanaChitanta;
    @JoinColumn(foreignKey = @ForeignKey(name = "politaId"))
    private String politaChitanta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getPersoanaChitanta() {
        return persoanaChitanta;
    }

    public void setPersoanaChitanta(String persoanaChitanta) {
        this.persoanaChitanta = persoanaChitanta;
    }

    public String getPolitaChitanta() {
        return politaChitanta;
    }

    public void setPolitaChitanta(String politaChitanta) {
        this.politaChitanta = politaChitanta;
    }

    @Override
    public String toString() {
        return "Chitanta{" +
                "id=" + id +
                ", data=" + data +
                ", suma=" + suma +
                ", descriere='" + descriere + '\'' +
                ", discount=" + discount +
                ", persoanaChitanta='" + persoanaChitanta + '\'' +
                ", politaChitanta='" + politaChitanta + '\'' +
                '}';
    }
}
