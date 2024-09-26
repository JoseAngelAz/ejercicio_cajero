package main;

import models.Cuenta;
import models.Cliente;
import interfaz.PantallaCajero;
import interfaz.TecladoCajero;
import interfaz.InterfazUsuario;
import servicio.ServicioCajero;

public class Main {
    public static void main(String[] args) {
        // Crear los componentes del cajero
        PantallaCajero pantalla = new PantallaCajero();
        TecladoCajero teclado = new TecladoCajero();
        ServicioCajero servicioCajero = new ServicioCajero();
        //crear datos para la cuenta
        String numero_cuenta = "5555555";
        double saldo_inicial = 500.00;
        String pin_cuenta = "password";

        // Crear una cuenta y cliente para probar el sistema
        Cuenta cuenta = new Cuenta(numero_cuenta, saldo_inicial);
        Cliente cliente = new Cliente("Juan Pérez", cuenta);

        // Crear la interfaz de usuario
        InterfazUsuario interfaz = new InterfazUsuario(pantalla, teclado, servicioCajero);

        // Iniciar sesión en el cajero
        pantalla.mostrarMensaje("Iniciando sesión en el cajero automático...");
        interfaz.iniciarSesion(cliente.getCuenta());
    }
}
