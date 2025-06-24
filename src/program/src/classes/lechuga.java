package classes;

/**
 * Clase que representa una lechuga en un sistema de monitoreo de cultivos.
 *
 * @author Josee
 */
public class lechuga {

    private int id;
    private String fechaPlantacion;
    private double temperatura;
    private double humedad;
    private String longitud;
    private double amperaje;

    /**
     * Constructor de la clase lechuga.
     *
     * @param id Identificador único de la lechuga.
     * @param fechaPlantacion Fecha de plantación (formato recomendado:
     * "yyyy-MM-dd").
     * @param temperatura Temperatura ideal en grados Celsius.
     * @param humedad Humedad ideal en porcentaje.
     * @param longitud Longitud de la lechuga
     * @param amperaje Amperaje de la lechuga
     */
    public lechuga(int id, String fechaPlantacion, double temperatura, double humedad, String longitud, double amperaje) {
        this.id = id;
        this.fechaPlantacion = fechaPlantacion;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.longitud = longitud;
        this.amperaje = amperaje;
    }

    /**
     * Obtiene información completa sobre la lechuga.
     *
     * @return Cadena con la información de la lechuga (ID, fecha de plantación,
     * temperatura, humedad, longitud y amperaje).
     */
    public String getInfo() {
        return "ID: " + id + ", Dia: " + fechaPlantacion + ", Temperatura: " + temperatura + " °C, Humedad: " + humedad + "%, Longitud: " + longitud + " cm" + ", Amperaje : " + amperaje + " A";
    }

    /**
     * Obtiene el identificador único de la lechuga.
     *
     * @return El ID de la lechuga.
     */
    public int getId() {
        return id;
    }
}
