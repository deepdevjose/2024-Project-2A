package classes;

/**
 * Clase que gestiona la autenticación de usuarios mediante la comparación de
 * credenciales.
 *
 * @author Josee
 */
public class autenticacion {

    /**
     * Nombre de usuario válido para la autenticación.
     */
    private static final String USUARIO = "usuario";

    /**
     * Contraseña válida para la autenticación. Se recomienda encarecidamente NO
     * almacenar contraseñas en texto plano. En un entorno real, utiliza
     * técnicas de hashing y salazón para proteger las contraseñas.
     */
    private static final String CONTRASENA = "1234567890123456"; // ¡Ojo! Inseguro en producción

    /**
     * Verifica si las credenciales proporcionadas son válidas.
     *
     * @param usuario El nombre de usuario a verificar.
     * @param contrasena La contraseña a verificar.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
    public static boolean autenticar(String usuario, String contrasena) {
        return usuario.equals(USUARIO) && contrasena.equals(CONTRASENA);
    }
}
