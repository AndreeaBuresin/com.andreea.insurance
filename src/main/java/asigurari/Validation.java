package asigurari;


public class Validation {
    public static boolean isPositiveInt(String number) {
        if (isInt(number)) {
            int i = Integer.parseInt(number);
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInt(String number) {
        try {
            int i = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isPositiveDouble(String number) {
        if (isDouble(number)) {
            double i = Double.parseDouble(number);
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDouble(String number) {
        boolean answer = true;

        if (number.matches("[0-9]*\\.?[0-9]+"))
            answer = true;
        else
            answer = false;

        return answer;
    }

    public static boolean isAlphaNumeric(String string, int minChar, int maxChar) {
        if (string.matches("[a-zA-Z0-9 ]{" + minChar + "," + maxChar + "}")) {
            return true;
        }
        return false;
    }

    public static boolean isEmail(String string) {
        if (string.matches("^[_A-Za-z0-9.]{3,}+@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})$")) {
            return true;
        }
        return false;
    }

    public static boolean isPhoneNumber(String string) {
        if (string.matches("0\\d{9}")) {
            return true;
        }
        return false;
    }

    public static boolean nameValidation(String name) {
        if (name.length() >= 3 && name.length() <= 20 && name.charAt(0) >= 'A' && name.charAt(0) <= 'Z' && name.matches("[A-Za-z]*")) {
            return true;
        }

        return false;
    }

    public static boolean dataValidation(String date){
        if (date.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")) {
            return true;
        }
        return false;
    }

    public static boolean cnpValidation(String cnp) {
        if (cnp.matches("\\b[1-8]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|\n" +
                "5[0-2]|99)\\d{4}\\b")
                && cnp.length() == 13) {
            return true;
        }
        return false;
    }
    public static boolean passwordValidation(String password){

        if (password.matches("(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,15})$")) {

            return true;
        }

        return false;
    }
    public static boolean personTypeValidation(String personType){
        if (personType.matches("[angajat]||[colaborator]||[client]")){
            return true;
        }
        return false;
    }

    public static boolean serieSasiuValidation(String serieSasiu) {
        if (serieSasiu.matches("([a-zA-Z0-9]*)")
                && serieSasiu.length() <= 17) {
            return true;
        }
        return false;
    }
    public static boolean nrIdentificareValidation(String nrIdentificare) {
        if (nrIdentificare.matches("(B|AB|AR|AG|BC|BH|BN|BT|BV|BR|BZ|CS" +
                "|CL|CJ|CT|CV|DB|DJ|GL|GR|GJ|HR|HD|IL|IS|IF|MM|MH|MS" +
                "|NT|OT|PH|SM|SJ|SB|SV|TR|TM|TL|VS|VL|VN\\s)(\\d{2}[A-Z]{3})")
                && ((nrIdentificare.length() == 7) || (nrIdentificare.length() == 6))){
            return true;
        }
        return false;
    }

}
