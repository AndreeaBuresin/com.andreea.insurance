package asigurari.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresa")
public class Adresa implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "oras",length = 20)
    String oras;

    @Column(name = "strada", length = 20)
    String strada;

    @Column(name = "numar", length = 11)
    int numar;

    @JoinColumn(foreignKey = @ForeignKey(name = "idPersoana"))
    String persoana;

    @JoinColumn(foreignKey = @ForeignKey(name = "idPolitaAdress"))
    String polita;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getPersoana() {
        return persoana;
    }

    public void setPersoana(String persoana) {
        this.persoana = persoana;
    }

    public String getPolita() {
        return polita;
    }

    public void setPolita(String polita) {
        this.polita = polita;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "id=" + id +
                ", oras='" + oras + '\'' +
                ", strada='" + strada + '\'' +
                ", numar=" + numar +
                ", persoana=" + persoana +
                ", polita=" + polita +
                '}';
    }
}
