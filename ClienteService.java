import java.util.regex.Pattern;

public class ClienteService {

	// Nombre
    public boolean validarNombre(String nombre) {
        return nombre != null && nombre.length() >= 2;
    }
	// Cuit
    public boolean validarCuit(String cuit) {
        String cuitPattern = "^([0-9]{11}|[0-9]{2}-[0-9]{8}-[0-9]{1})$";
        return cuit != null && Pattern.matches(cuitPattern, cuit) && validarAlgoritmoCuit(cuit);
    }

    private boolean validarAlgoritmoCuit(String cuit) {
        cuit = cuit.replace("-", "");
        
        int[] multiplicadores = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
        int suma = 0;
        
        for (int i = 0; i < 10; i++) {
            suma += Character.getNumericValue(cuit.charAt(i)) * multiplicadores[i];
        }

        int resto = suma % 11;
        int digitoVerificador = resto == 0 ? 0 : resto == 1 ? 9 : 11 - resto;

        return digitoVerificador == Character.getNumericValue(cuit.charAt(10));}

    // Mail
    public boolean validarEmail(String email) {
        String emailPattern = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        return email != null && Pattern.matches(emailPattern, email);
    }

    // Núm de celu
    public boolean validarCelular(String celular) {
        String celularPattern = "^[0-9()-]+$";
        return celular != null && Pattern.matches(celularPattern, celular);
    }
}