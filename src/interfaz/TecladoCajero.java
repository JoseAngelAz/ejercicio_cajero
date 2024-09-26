package interfaz;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TecladoCajero {
    private Scanner scanner = new Scanner(System.in);

    public String obtenerEntrada() {
        return scanner.nextLine();
    }

    public double obtenerMonto() {
        double monto = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                monto = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número válido.");
                scanner.next();  // Limpiar entrada
            }
        }
        return monto;
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
