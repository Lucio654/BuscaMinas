import java.util.Random;

public class Tablero {
    private Celda[][] celdas;
    private int filas;
    private int columnas;
    private int totalMinas;
    
    private void colocarMinas() {
        int minasColocadas = 0;
        Random random = new Random();
        
        while (minasColocadas < totalMinas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            
            Celda celda = celdas[fila][columna];
            if (!celda.isTieneMina()) {
                celda.setTieneMina(true);
                minasColocadas++;
            }
        }
    }

    public Celda getCelda(int fila, int columna) {
    if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
        return celdas[fila][columna];
    }
    return null;
   }
    private void calcularNumeros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!celdas[i][j].isTieneMina()) {
                    int count = contarMinasAlrededor(i, j);
                    celdas[i][j].setMinasAlrededor(count);
                }
            }
        }
    }

    private int contarMinasAlrededor(int fila, int columna) {
        int count = 0;
        for (int i = Math.max(0, fila - 1); i <= Math.min(filas - 1, fila + 1); i++) {
            for (int j = Math.max(0, columna - 1); j <= Math.min(columnas - 1, columna + 1); j++) {
                if (celdas[i][j].isTieneMina()) {
                    count++;
                }
            }
        }
        return count;
    }


    // Constructor
    public Tablero(int filas, int columnas, int totalMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.totalMinas = totalMinas;
        this.celdas = new Celda[filas][columnas];
        inicializarCeldasVacias();
        colocarMinas();
        calcularNumeros();
    }
    
    private void inicializarCeldasVacias() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }
    
    public void mostrarTablero() {
        System.out.print("  ");
        for (int j = 0; j < columnas; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        
        for (int i = 0; i < filas; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < columnas; j++) {
                Celda celda = celdas[i][j];
                // TEMPORAL: mostrar todo como descubierto
                if (celda.isTieneMina()) {
                    System.out.print("* ");
                } else {
                    int minasAlrededor = celda.getMinasAlrededor();
                    System.out.print(minasAlrededor + " ");
                }
            }
            System.out.println();
        }
    }
} 
    