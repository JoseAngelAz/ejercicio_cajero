package servicio;

import models.Cuenta;
import excepciones.FondosInsuficientesException;
import utilidades.Validaciones;

public class ServicioCajero {

    /**
     * Procesa el retiro de una cuenta si se cumplen todas las condiciones.
     * 
     * @param cuenta La cuenta desde la cual se va a retirar dinero
     * @param monto  El monto a retirar
     * @throws FondosInsuficientesException Si no hay saldo suficiente en la cuenta
     * @throws IllegalArgumentException Si el monto ingresado no es válido (<= 0)
     */
    public void procesarRetiro(Cuenta cuenta, double monto) throws FondosInsuficientesException, IllegalArgumentException {
        // Validamos que el monto sea positivo utilizando la clase Validaciones
        if (!Validaciones.esMontoValido(monto)) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        // Intentamos realizar el retiro usando el método de la clase Cuenta
        cuenta.retirar(monto);
    }

    /**
     * Procesa el depósito a una cuenta si el monto es válido.
     * 
     * @param cuenta La cuenta a la cual se va a depositar
     * @param monto  El monto a depositar
     * @throws IllegalArgumentException Si el monto ingresado no es válido (<= 0)
     */
    public void procesarDeposito(Cuenta cuenta, double monto) {
        // Validamos que el monto sea positivo antes de depositar
        if (!Validaciones.esMontoValido(monto)) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        // Procedemos a depositar el dinero
        cuenta.depositar(monto);
    }

    /**
     * Verifica si el PIN ingresado es correcto para la cuenta.
     * 
     * @param cuenta La cuenta a verificar
     * @param pin    El PIN ingresado por el usuario
     * @return true si el PIN es correcto, false si no lo es
     */
    public boolean verificarPin(Cuenta cuenta, String pin) {
        return cuenta.revisar_pin(pin);
    }
}
