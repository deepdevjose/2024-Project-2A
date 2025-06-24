package classes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Clase para encriptar y desencriptar texto utilizando el algoritmo AES.
 *
 * @author Josee
 */
public class encriptadorAES {

    private static final String CLAVE = "1234567890123456"; // ¡CLAVE INSEGURA!

    /**
     * Encripta un texto plano utilizando el algoritmo AES.
     *
     * @param texto El texto a encriptar.
     * @return El texto encriptado en formato Base64, o null si ocurre un error.
     */
    public static String encriptar(String texto) {
        try {
            SecretKeySpec key = new SecretKeySpec(CLAVE.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] textoEncriptado = cipher.doFinal(texto.getBytes());
            return Base64.getEncoder().encodeToString(textoEncriptado);
        } catch (Exception e) {
            // Manejo de errores: Imprime la traza de la excepción, pero en un entorno
            // de producción, registra el error en un log y devuelve un mensaje genérico.
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Desencripta un texto encriptado en formato Base64 utilizando el algoritmo
     * AES.
     *
     * @param textoEncriptado El texto encriptado en formato Base64.
     * @return El texto desencriptado, o null si ocurre un error.
     */
    public static String desencriptar(String textoEncriptado) {
        try {
            SecretKeySpec key = new SecretKeySpec(CLAVE.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] textoDesencriptado = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));
            return new String(textoDesencriptado);
        } catch (Exception e) {
            // Manejo de errores: Similar al método 'encriptar'
            e.printStackTrace();
            return null;
        }
    }
}
