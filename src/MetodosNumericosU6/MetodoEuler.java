package MetodosNumericosU6;

public class MetodoEuler {

    // Función de la EDO: y' = f(x, y) = x - y
    public static double evaluarFuncion(double x, double y) {
        return x - y;
    }

    // Solución exacta de la EDO: y(x) = x - 1 + 2e^(-x)
    public static double solucionExacta(double x) {
        return x - 1 + 2 * Math.exp(-x);
    }

}