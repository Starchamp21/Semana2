package aplicacion;

public class Main {
    // 1. Cuento dígitos recursivos.
    public static int contarDigito(int numero, int digito) {
        if (numero == 0) {
            return 0; // Caso base.
        }

        int ultimo = numero % 10;
        int suma = (ultimo == digito) ? 1 : 0;

        return suma + contarDigito(numero / 10, digito);
    }

    // 2. Laberinto recursivo.
    public static boolean hayCamino(char[][] laberinto, int fila, int col) {

        // Fuera de límites.
        if (fila < 0 || col < 0 || fila >= laberinto.length || col >= laberinto[0].length) {
            return false;
        }

        // Si es pared o ya visitado.
        if (laberinto[fila][col] == '#' || laberinto[fila][col] == 'V') {
            return false;
        }

        // Si es salida.
        if (laberinto[fila][col] == 'S') {
            return true;
        }

        // Marco como visitado.
        laberinto[fila][col] = 'V';

        // Explorar en 4 direcciones.
        return hayCamino(laberinto, fila - 1, col) ||  // arriba.
               hayCamino(laberinto, fila + 1, col) ||  // abajo.
               hayCamino(laberinto, fila, col - 1) ||  // izquierda.
               hayCamino(laberinto, fila, col + 1);    // derecha.
    }

    public static void main(String[] args) {
        // PRUEBA 1: contar dígito.
        int numero = 12233421;
        int digito = 2;

        int resultado = contarDigito(numero, digito);
        System.out.println("El dígito " + digito + " aparece " + resultado + " veces en " + numero);

        // PRUEBA 2: laberinto.
        char[][] laberinto = {
                {'.', '.', '.', '#'},
                {'#', '#', '.', '#'},
                {'.', '.', '.', '.'},
                {'#', '#', '.', 'S'}
        };

        boolean existeCamino = hayCamino(laberinto, 0, 0);

        if (existeCamino) {
            System.out.println("Existe un camino hasta la salida.");
        } else {
            System.out.println("No existe camino hasta la salida.");
        }
    }
}