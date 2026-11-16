package MetodosNumericosU6;

import static MetodosNumericosU6.MetodoEuler.evaluarFuncion;
import static MetodosNumericosU6.MetodoEuler.solucionExacta;

public class MainEuler {
    public static void main(String[] args) {
        // Datos iniciales del problema
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1; // Variar: 0.1, 0.05, 0.01
        double xFinal = 0.3;


        // Criterio de paro (numero total de pasos N)
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("\n\t x_n\t y_n (Euler)");
        System.out.println("--------------------------------");
        System.out.printf("%d\t %.4f\t %.4f\n", 0, x, y);

        // Ciclo del método de Euler
        for (int i = 0; i < nPasos; i++) {

            // Pendiente en el punto actual: f(x_n, y_n)
            double pendiente = evaluarFuncion(x, y);
            // Fórmula de Euler: y_{n+1} = y_n + h * f(x_n, y_n)
            y = y + h * pendiente;

            x = x0 + (i + 1) * h; // evita acumular error de punto flotante

            System.out.printf("%d\t %.4f\t %.4f\n", i + 1, x, y);
        }

        // Comparación con la solución exacta
        double yExacta = solucionExacta(xFinal);
        System.out.printf("%nSolucion exacta y(%.1f) = %.6f%n", xFinal, yExacta);
        System.out.printf("Aproximacion Euler    = %.6f%n", y);
        System.out.printf("Error absoluto        = %.6f%n", Math.abs(yExacta - y));
    }
}
