package asigurari.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by buresina on 31/10/2016.
 */
@Entity
public class Associate extends Person {

    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "contractDate")
    private LocalDate contractDate;



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    @Override
    public String toString() {
        return "Associate{" +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", contractDate=" + contractDate +
                '}';
    }
}
