package exceptions;

public class SistemaValidador {
    public static void validarNombre(String nombre) throws NombreVacioException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NombreVacioException("El nombre no puede estar vacío.");
        }
    }
}
