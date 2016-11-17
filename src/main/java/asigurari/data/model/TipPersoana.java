package asigurari.data.model;

/**
 * Created by buresina on 16/11/2016.
 */
public enum TipPersoana {
    ANGAJAT("Angajat"),
    COLABORATOR("Colaborator"),
    ASIGURAT("Asigurat");

    private String value;

    TipPersoana(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TipPersoana{" +
                "value='" + value + '\'' +
                '}';
    }

    public static String valueOf(TipPersoana tipPersoana) {
        return String.valueOf(tipPersoana);
    }
}
