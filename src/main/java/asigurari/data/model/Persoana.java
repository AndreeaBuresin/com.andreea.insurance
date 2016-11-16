package asigurari.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persoana")
public class Persoana implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

    public void setTipPersoana(TipPersoana tipPersoana) {
        this.tipPersoana = tipPersoana;
    }

    public TipPersoana getTipPersoana() {
        return tipPersoana;
    }

    //persoanaType
    @Enumerated(EnumType.STRING)


    @Override
    public String toString() {
        return "Persoana{" +
                "cnp=" + cnp +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", telefon=" + telefon +
                ", tipPersoana=" + tipPersoana +
                '}';
    }


}