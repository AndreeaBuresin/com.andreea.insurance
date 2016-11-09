package asigurari.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "despagubire")
public class Despagubire implements Serializable{

    @Id
    @Column(name = "iddespagubire", length = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "dataDespagubire")
    LocalDate data;

    @Column(name = "sumaDespagubire")
    double sumaDespagubire;

    @Column(name = "descriereAvarii")
    String descriereAvarii;

    @JoinColumn(foreignKey = @ForeignKey(name = "idPolitaValabila"))
    String polita;
    @JoinColumn(foreignKey = @ForeignKey(name = "idPersoanaImplicata"))
    String persoana;


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

    public double getSumaDespagubire() {
        return sumaDespagubire;
    }

    public void setSumaDespagubire(double sumaDespagubire) {
        this.sumaDespagubire = sumaDespagubire;
    }

    public String getDescriereAvarii() {
        return descriereAvarii;
    }

    public void setDescriereAvarii(String descriereAvarii) {
        this.descriereAvarii = descriereAvarii;
    }

    public String getPolita() {
        return polita;
    }

    public void setPolita(String polita) {
        this.polita = polita;
    }

    public String getPersoana() {
        return persoana;
    }

    public void setPersoana(String persoana) {
        this.persoana = persoana;
    }

    @Override
    public String toString() {
        return "Despagubire{" +
                "id=" + id +
                ", data=" + data +
                ", sumaDespagubire=" + sumaDespagubire +
                ", descriere='" + descriereAvarii + '\'' +
                ", polita='" + polita + '\'' +
                ", persoana='" + persoana + '\'' +
                '}';
    }
}
