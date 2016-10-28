package asigurari.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    int id;  //id-ul va reprezenta id-ul entitatii de care apartine adresa respectiva
    @Column (name="town")
    String town;

    @Column(name = "street")
    String street;

    @Column(name = "number")
    int number;

    @Column(name = "apartment")
    int apartment;


    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", ap=" + apartment +
                '}';
    }
}
