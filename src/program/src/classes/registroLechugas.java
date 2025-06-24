package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que gestiona el registro de lechugas y su almacenamiento en un archivo de texto.
 *
 * @author Josee
 */
public class registroLechugas {
    
    /**
     * Logger para registrar errores y eventos importantes.
     */
    private static final Logger LOGGER = Logger.getLogger(registroLechugas.class.getName());

    /**
     * Lista que almacena las instancias de lechuga registradas.
     */
    private ArrayList<lechuga> lechugas;

    /**
     * Constructor de la clase registroLechugas.
     * Inicializa la lista de lechugas.
     */
    public registroLechugas() {
        lechugas = new ArrayList<>();
    }

    /**
     * Agrega una nueva lechuga al registro.
     *
     * @param lechuga La instancia de lechuga a agregar.
     */
    public void agregarLechuga(lechuga lechuga) {
        lechugas.add(lechuga);
    }

    /**
     * Guarda la información de todas las lechugas registradas en un archivo de texto.
     * El archivo se crea o sobreescribe con el nombre "registro_lechugas.txt".
     * En caso de error de escritura, se registra un mensaje en el log.
     */
    public void guardarRegistro() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("registro_lechugas.txt"))) {
            for (lechuga lechuga : lechugas) {
                writer.println(lechuga.getInfo());
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al guardar el registro de lechugas: {0}", e.getMessage());
        }
    }
}
