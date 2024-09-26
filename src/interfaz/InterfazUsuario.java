package interfaz;

import models.Cuenta;
import servicio.ServicioCajero;

public class InterfazUsuario {

    private PantallaCajero pantalla;
    private TecladoCajero teclado;
    private ServicioCajero servicioCajero;

    public InterfazUsuario(PantallaCajero pantalla, TecladoCajero teclado, ServicioCajero servicioCajero) {
        this.pantalla = pantalla;
        this.teclado = teclado;
        this.servicioCajero = servicioCajero;
    }

    public void iniciarSesion(Cuenta cuenta) {
        int intentos = 0;
        boolean accesoConcedido = false;

        while (intentos < 3 && !accesoConcedido) {
            pantalla.mostrarMensaje("Ingrese su PIN: ");
            String pin = teclado.obtenerEntrada();

            if (servicioCajero.verificarPin(cuenta, pin)) {
                pantalla.mostrarMensaje("¡Bienvenido!");
                accesoConcedido = true;
                mostrarMenu(cuenta);
            } else {
                pantalla.mostrarError("PIN incorrecto");
                intentos++;
            }
        }

        if (!accesoConcedido) {
            pantalla.mostrarError("Demasiados intentos fallidos. Adiós.");
        }
    }

    private void mostrarMenu(Cuenta cuenta) {
        boolean salir = false;
        while (!salir) {
            pantalla.mostrarMensaje("Seleccione una opción:");
            pantalla.mostrarMensaje("1. Consultar saldo");
            pantalla.mostrarMensaje("2. Retirar dinero");
            pantalla.mostrarMensaje("3. Depositar dinero");
            pantalla.mostrarMensaje("4. Salir");

            String opcion = teclado.obtenerEntrada();
            switch (opcion) {
                case "1":
                    pantalla.mostrarMensaje("El saldo es: " + cuenta.getSaldo());
                    break;
                case "2":
                    pantalla.mostrarMensaje("Ingrese el monto a retirar:");
                    double montoRetiro = teclado.obtenerMonto();
                    try {
                        servicioCajero.procesarRetiro(cuenta, montoRetiro);
                        pantalla.mostrarMensaje("Retiro exitoso. Saldo restante: " + cuenta.getSaldo());
                    } catch (Exception e) {
                        pantalla.mostrarError(e.getMessage());
                    }
                    break;
                case "3":
                    pantalla.mostrarMensaje("Ingrese el monto a depositar:");
                    double montoDeposito = teclado.obtenerMonto();
                    servicioCajero.procesarDeposito(cuenta, montoDeposito);
                    pantalla.mostrarMensaje("Depósito exitoso. Saldo actual: " + cuenta.getSaldo());
                    break;
                case "4":
                    pantalla.mostrarMensaje("Gracias por usar el cajero. Adiós.");
                    salir = true;
                    break;
                default:
                    pantalla.mostrarError("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
