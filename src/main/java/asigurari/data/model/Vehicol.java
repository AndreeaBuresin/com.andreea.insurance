package asigurari.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "vehicol")
public class Vehicol implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idSerieSasiu")
    private String serieSasiu;

    @Column(name = "nrIdentificare")
    private String nrIdentificare;

    @Column(name = "marca")
    private String marca;

    @Column(name = "model")
    private String model;

    @Column(name = "combustibil")
    private String combustibil;

    @Column(name = "cilindri")
    private int cilindri;

    @Column(name = "kw")
    private int kw;

    @Column(name = "masaMaxAsigurata")
    private int masaMaxAutorizata;

    @Column(name = "dataFabricatie")
    private LocalDate dataFabricatie;

    @Column(name = "accident")
    private int accident;

    @Column(name = "sumaAsigurata")
    private double sumaAsigurata;

    private Persoana persoana;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persoana getPersoana() {
        return this.persoana;
    }

    public void setPersoana(Persoana persoana) {
        this.persoana = persoana;
    }

    public String getSerieSasiu() {
        return serieSasiu;
    }

    public void setSerieSasiu(String serieSasiu) {
        this.serieSasiu = serieSasiu;
    }

    public String getNrIdentificare() {
        return nrIdentificare;
    }

    public void setNrIdentificare(String nrIdentificare) {
        this.nrIdentificare = nrIdentificare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public int getCilindri() {
        return cilindri;
    }

    public void setCilindri(int cilindri) {
        this.cilindri = cilindri;
    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }

    public int getMasaMaxAutorizata() {
        return masaMaxAutorizata;
    }

    public void setMasaMaxAutorizata(int masaMaxAutorizata) {
        this.masaMaxAutorizata = masaMaxAutorizata;
    }

    public LocalDate getDataFabricatie() {
        return dataFabricatie;
    }

    public void setDataFabricatie(LocalDate dataFabricatie) {
        this.dataFabricatie = dataFabricatie;
    }

    public int getAccident() {
        return accident;
    }

    public void setAccident(int accident) {
        this.accident = accident;
    }

    public double getSumaAsigurata() {
        return sumaAsigurata;
    }

    public void setSumaAsigurata(double sumaAsigurata) {
        this.sumaAsigurata = sumaAsigurata;
    }

    @Override
    public String toString() {
        return "Vehicol{" +
                "id=" + id +
                ", serieSasiu='" + serieSasiu + '\'' +
                ", nrIdentificare='" + nrIdentificare + '\'' +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", combustibil='" + combustibil + '\'' +
                ", cilindri=" + cilindri +
                ", kw=" + kw +
                ", masaMaxAutorizata=" + masaMaxAutorizata +
                ", dataFabricatie=" + dataFabricatie +
                ", accident=" + accident +
                ", sumaAsigurata=" + sumaAsigurata +
                ", persoana=" + persoana +
                '}';
    }
}
