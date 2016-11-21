package asigurari.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persoana")
public class Persoana implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cnp")
    private long cnp;

    @Column(name = "nume", length = 20)
    private  String nume;

    @Column(name = "prenume", length = 20)
    private  String prenume;

    @Column(name = "email", length = 45)
    private  String email;

    @Column(name = "telefon", length = 10)
    private  long telefon;


    @Column(name = "tipPersoana")
    private TipPersoana tipPersoana;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCnp() {
        return this.cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefon() {
        return this.telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

    public TipPersoana getTipPersoana() {
        return this.tipPersoana;
    }

    public void setTipPersoana(TipPersoana tipPersoana) {
        this.tipPersoana = tipPersoana;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "\nid: " + id +
                ", cnp: " + cnp +
                ", nume: '" + nume + '\'' +
                ", prenume: '" + prenume + '\'' +
                ", email: " + email + '\'' +
                ", telefon: " + telefon +
                ", tipPersoana: " + tipPersoana +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoana)) return false;

        Persoana persoana = (Persoana) o;

        if (this.id != persoana.id) return false;
        if (this.cnp != persoana.cnp) return false;
        if (this.telefon != persoana.telefon) return false;
        if (this.nume != null ? !this.nume.equals(persoana.nume) : persoana.nume != null) return false;
        if (this.prenume != null ? !this.prenume.equals(persoana.prenume) : persoana.prenume != null) return false;
        if (this.email != null ? !this.email.equals(persoana.email) : persoana.email != null) return false;
        return this.tipPersoana == persoana.tipPersoana;

    }

    @Override
    public int hashCode() {
        int result = this.id;
        result = 31 * result + (int) (this.cnp ^ this.cnp >>> 32);
        result = 31 * result + (this.nume != null ? this.nume.hashCode() : 0);
        result = 31 * result + (this.prenume != null ? this.prenume.hashCode() : 0);
        result = 31 * result + (this.email != null ? this.email.hashCode() : 0);
        result = 31 * result + (int) (this.telefon ^ this.telefon >>> 32);
        result = 31 * result + (this.tipPersoana != null ? this.tipPersoana.hashCode() : 0);
        return result;
    }
}
