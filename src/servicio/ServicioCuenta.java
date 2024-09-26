package servicio;

import models.Cuenta;

public class ServicioCuenta {
    public void mostrarSaldo(Cuenta cuenta) {
        System.out.printf("El saldo actual de la cuenta %s es: %.2f\n", cuenta.getNumeroCuenta(), cuenta.getSaldo());
    }
}
