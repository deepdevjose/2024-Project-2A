package classes;

/**
 * Clase que representa una lechuga en un sistema de monitoreo de cultivos, con
 * la información adicional encriptada para mayor seguridad.
 *
 * @author Josee
 */
public class lechugaEncriptada {

    private int id;
    private String fechaPlantacion;
    private double temperatura;
    private double humedad;
    private String longitud;
    private double amperaje;
    private String textoInfo;

    /**
     * Constructor de la clase lechugaEncriptada.
     *
     * @param id Identificador único de la lechuga.
     * @param fechaPlantacion Fecha de plantación (formato recomendado:
     * "yyyy-MM-dd").
     * @param temperatura Temperatura ideal en grados Celsius.
     * @param humedad Humedad ideal en porcentaje.
     * @param longitud Longitud de la lechuga.
     * @param amperaje Amperaje de la lechuga.
     */
    public lechugaEncriptada(int id, String fechaPlantacion, double temperatura, double humedad, String longitud, double amperaje) {
        this.id = id;
        this.fechaPlantacion = fechaPlantacion;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.longitud = longitud;
        this.amperaje = amperaje;
        this.textoInfo = generarTextoInfo(); // Encripta la información al crear el objeto
    }

    /**
     * Genera el texto con la información de la lechuga.
     *
     * @return Cadena con la información de la lechuga (ID, fecha, temperatura,
     * humedad, longitud y amperaje). Se asume que este método realiza la
     * encriptación del texto.
     */
    private String generarTextoInfo() {
        // Aquí se realizaría la encriptación de la información
        // (Este es un ejemplo simplificado, la encriptación real sería más compleja)
        return "ID: " + id + ", Dia: " + fechaPlantacion + ", Temperatura: " + temperatura + " °C, Humedad: " + humedad + "%, Longitud: " + longitud + " cm" + ", Amperaje : " + amperaje + " A";
    }

    /**
     * Obtiene la información de la lechuga (encriptada).
     *
     * @return El texto encriptado con la información de la lechuga.
     */
    public String getInfo() {
        return textoInfo;
    }
}
