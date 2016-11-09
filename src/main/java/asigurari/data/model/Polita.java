package asigurari.data.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "polita")
public class Polita {

    @Id
    @Column(name = "idpolita", length = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "dataInceput")
    LocalDate dataInceput;

    @Column(name = "dataSfarsit")
    LocalDate dataSfarsit;

    @JoinColumn(foreignKey = @ForeignKey(name = "nrChitanta"))
    String chitanta;
    @JoinColumn(foreignKey = @ForeignKey(name = "vehicolId"))
    String vehicol;
    @JoinColumn(foreignKey = @ForeignKey(name = "idAsigurat"))
    String asigurat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(LocalDate dataInceput) {
        this.dataInceput = dataInceput;
    }

    public LocalDate getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(LocalDate dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public String getChitanta() {
        return chitanta;
    }

    public void setChitanta(String chitanta) {
        this.chitanta = chitanta;
    }

    public String getVehicol() {
        return vehicol;
    }

    public void setVehicol(String vehicol) {
        this.vehicol = vehicol;
    }

    public String getAsigurat() {
        return asigurat;
    }

    public void setAsigurat(String asigurat) {
        this.asigurat = asigurat;
    }

    @Override
    public String toString() {
        return "Polita{" +
                "id=" + id +
                ", dataInceput=" + dataInceput +
                ", dataSfarsit=" + dataSfarsit +
                ", chitanta='" + chitanta + '\'' +
                ", vehicol='" + vehicol + '\'' +
                ", asigurat='" + asigurat + '\'' +
                '}';
    }
}
