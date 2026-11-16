package MetodosNumericosU6;

public class MetodoRungeKutta {
    // Función de la EDO: y' = f(x, y) = x + y
    public static double evaluarFuncion(double x, double y) {
        return x + y;
    }

    // Solución exacta de la EDO: y(x) = 2e^x - x - 1
    public static double solucionExacta(double x) {
        return 2 * Math.exp(x) - x - 1;
    }

}