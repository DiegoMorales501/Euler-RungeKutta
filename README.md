# Métodos Numéricos – Unidad 6

Implementación en Java de dos métodos numéricos para resolver ecuaciones diferenciales ordinarias (EDO) 
con valor inicial: **Método de Euler** y **Runge-Kutta de 4º orden (RK4)**. Cada método se compara contra 
la solución exacta de su problema.

## Estructura del proyecto

```
MetodosNumericosU6/
├── MetodoEuler.java        # Función f(x, y) y solución exacta (Euler)
├── Main.java               # Ejecuta el método de Euler
├── MetodoRungeKutta.java   # Función f(x, y) y solución exacta (RK4)
└── MainRungeKutta.java     # Ejecuta el método RK4
```

Todas las clases pertenecen al paquete `MetodosNumericosU6`. Las clases `Main` usan **import estático** para llamar 
a `evaluarFuncion` y `solucionExacta` sin el prefijo de la clase.

## Problemas resueltos

| Método | EDO | Condición inicial | Solución exacta |
|--------|-----|-------------------|-----------------|
| Euler | y' = x − y | y(0) = 1 | y(x) = x − 1 + 2e^(−x) |
| Runge-Kutta 4 | y' = x + y | y(0) = 1 | y(x) = 2e^x − x − 1 |

## Fórmulas

**Euler**

```
y_{n+1} = y_n + h · f(x_n, y_n)
```

**Runge-Kutta de 4º orden**

```
k1 = f(x_n, y_n)
k2 = f(x_n + h/2, y_n + h·k1/2)
k3 = f(x_n + h/2, y_n + h·k2/2)
k4 = f(x_n + h,   y_n + h·k3)

y_{n+1} = y_n + (h/6)(k1 + 2·k2 + 2·k3 + k4)
```

## Parámetros

Se definen al inicio del `main` de cada clase:

| Variable | Valor | Descripción |
|----------|-------|-------------|
| `x0` | 0.0 | Valor inicial de x |
| `y0` | 1.0 | Condición inicial y(x0) |
| `h` | 0.1 | Tamaño de paso (se puede variar: 0.1, 0.05, 0.01) |
| `xFinal` | 0.3 | Punto donde se aproxima la solución |

El criterio de paro es el número total de pasos: `N = round((xFinal − x0) / h)`.
Además, `x` se calcula como `x0 + (i + 1) · h` en cada iteración para no acumular error de punto flotante.

## Compilación y ejecución

Desde la carpeta que contiene el directorio `MetodosNumericosU6`:

```bash
# Compilar
javac MetodosNumericosU6/*.java

# Ejecutar Euler
java MetodosNumericosU6.Main

# Ejecutar Runge-Kutta 4
java MetodosNumericosU6.MainRungeKutta
```

Si usas un IDE (NetBeans, IntelliJ, Eclipse), basta con abrir el proyecto y ejecutar cada clase `Main`.

## Resultados esperados (h = 0.1, xFinal = 0.3)

### Euler

```
	 x_n	 y_n (Euler)
--------------------------------
0	 0.0000	 1.0000
1	 0.1000	 0.9000
2	 0.2000	 0.8200
3	 0.3000	 0.7580

Solucion exacta y(0.3) = 0.781636
Aproximacion Euler    = 0.758000
Error absoluto        = 0.023636
```

### Runge-Kutta 4

```
	 x_n	 y_n (RK4)
--------------------------------
0	 0.0000	 1.0000
1	 0.1000	 1.1103
2	 0.2000	 1.2428
3	 0.3000	 1.3997

Solucion exacta y(0.3) = 1.399718
Aproximacion RK4      = 1.399717
Error absoluto        = ~5e-07  (orden de 10^-7)
```
