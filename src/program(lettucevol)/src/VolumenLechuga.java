import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;

import java.util.function.Function;

public class VolumenLechuga {
    public static void main(String[] args) throws Exception {

        //Definir la funcion para el radio de la lechuga
        Function<Double, Double> radio = t -> 3 + 2 * Math.sin(2 * t);

        // Definir los limites de la integracion
        double limiteInferior = 0.0;
        double limiteSuperior = Math.PI / 4.0;

        // Calcular el volumen exacto utilizando el metodo de discos
        double volumenExacto = calcularVolumenExacto(radio, limiteInferior, limiteSuperior);

        // Imprimir el resultado
        System.out.println("El volumen exacto de la lechuga es: " + volumenExacto + "cm³");
    
        // Crear los datos para el grafico
        DefaultXYDataset dataset = crearDataset(radio, limiteInferior, limiteSuperior);

        // Crear el grafico
        ChartFrame frame = crearGrafico(dataset);
        
        // Mostrar el grafico
        frame.pack();
        frame.setVisible(true);
    }

    public static double calcularVolumenExacto(Function<Double, Double> radio, double limiteInferior, double limiteSuperior) {

        // Definir la precision para el calculo numerico
        int n = 1000;

        // Calcular el incremento en altura
        double deltaT = (limiteSuperior - limiteInferior) / n;

        // Calcular el volumen aproximado
        double volumen = 0.0;
        for(int i = 0; i < n; i++){
            double t = limiteInferior + i * deltaT;
            double r = radio.apply(t);
            double area = Math.PI * Math.pow(r, 2);
            volumen += area * deltaT;
        }

        return volumen;
    }

    public static DefaultXYDataset crearDataset(Function<Double, Double> radio, double limiteInferior, double limiteSuperior){

        DefaultXYDataset dataset = new DefaultXYDataset();
        
        // Numero de puntos en el grafico
        int n = 100; 
        double [][] data = new double[2][n];
        double deltaT = (limiteSuperior - limiteInferior) / (n-1);

        for(int i = 0; i < n; i++){
            double t = limiteInferior + i * deltaT;
            double r = radio.apply(t);
            data[0][i] = t;
            data[1][i] = r;
        }

        dataset.addSeries("Radio", data);

        return dataset;
    }

    public static ChartFrame crearGrafico(DefaultXYDataset dataset){

        String titulo = "Grafico de la lechuga";
        String etiquetaX = "Altura(t)";
        String etiquetaY = "Radio(r)";

        // Crear el grafico de dispersion
        org.jfree.chart.JFreeChart chart = ChartFactory.createScatterPlot(titulo, etiquetaX, etiquetaY, dataset,
                PlotOrientation.VERTICAL, true, true, false);
        
        ChartFrame frame = new ChartFrame("Grafico de la lechuga", chart);

        return frame;
    }
}