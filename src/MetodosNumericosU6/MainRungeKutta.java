package MetodosNumericosU6;

import static MetodosNumericosU6.MetodoRungeKutta.evaluarFuncion;
import static MetodosNumericosU6.MetodoRungeKutta.solucionExacta;

public class MainRungeKutta {

    public static void main(String[] args) {
        // Datos iniciales del problema
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        double xFinal = 0.3;

        // Criterio de paro (numero total de pasos N)
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("\n\t x_n\t y_n (RK4)");
        System.out.println("--------------------------------");
        System.out.printf("%d\t %.4f\t %.4f\n", 0, x, y);

        // Ciclo del método de Runge-Kutta de 4º orden
        for (int i = 0; i < nPasos; i++) {
            double k1 = evaluarFuncion(x, y);
            double k2 = evaluarFuncion(x + h / 2, y + h * k1 / 2);
            double k3 = evaluarFuncion(x + h / 2, y + h * k2 / 2);
            double k4 = evaluarFuncion(x + h, y + h * k3);

            // Fórmula RK4: y_{n+1} = y_n + (h/6)(k1 + 2k2 + 2k3 + k4)
            y = y + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
            x = x0 + (i + 1) * h;
            System.out.printf("%d\t %.4f\t %.4f\n", i + 1, x, y);
        }

        // Comparación con la solución exacta
        double yExacta = solucionExacta(xFinal);
        System.out.printf("%nSolucion exacta y(%.1f) = %.6f%n", xFinal, yExacta);
        System.out.printf("Aproximacion RK4      = %.6f%n", y);
        System.out.printf("Error absoluto        = %.6e%n", Math.abs(yExacta - y));
    }
}
