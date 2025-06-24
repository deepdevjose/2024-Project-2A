package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que gestiona el registro de lechugas encriptadas y su almacenamiento en
 * un archivo de texto.
 *
 * @author Josee
 */
public class registroLechugasEncriptadas {

    /**
     * Logger para registrar errores y eventos importantes.
     */
    private static final Logger LOGGER = Logger.getLogger(registroLechugasEncriptadas.class.getName());

    /**
     * Lista que almacena las instancias de lechugaEncriptada registradas.
     */
    private ArrayList<lechugaEncriptada> lechugasEncriptadas;

    /**
     * Constructor de la clase registroLechugasEncriptadas. Inicializa la lista
     * de lechugas encriptadas.
     */
    public registroLechugasEncriptadas() {
        lechugasEncriptadas = new ArrayList<>();
    }

    /**
     * Agrega una nueva lechuga encriptada al registro.
     *
     * @param lechuga La instancia de lechugaEncriptada a agregar.
     */
    public void agregarLechuga(lechugaEncriptada lechuga) {
        lechugasEncriptadas.add(lechuga);
    }

    /**
     * Guarda la información encriptada de todas las lechugas registradas en un
     * archivo de texto. El archivo se crea o se añade al final ("append mode")
     * con el nombre "registro_lechugas_encriptado.txt". En caso de error de
     * encriptación, se registra un mensaje en la consola. En caso de error de
     * escritura, se registra un mensaje en el log.
     */
    public void guardarRegistroEncriptado() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("registro_lechugas_encriptado.txt", true))) { // Append mode
            for (lechugaEncriptada lechuga : lechugasEncriptadas) {
                String textoEncriptado = encriptadorAES.encriptar(lechuga.getInfo());
                if (textoEncriptado != null) {
                    writer.println(textoEncriptado);
                } else {
                    LOGGER.log(Level.WARNING, "Error al encriptar el registro de la lechuga con ID: {0}", lechuga.getInfo());
                }
            }
            LOGGER.log(Level.INFO, "Registro encriptado guardado en registro_lechugas_encriptado.txt");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al guardar el registro de lechugas encriptadas: {0}", e.getMessage());
        }
    }
}
