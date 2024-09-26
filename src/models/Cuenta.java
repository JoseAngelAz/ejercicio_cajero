package models;
import excepciones.FondosInsuficientesException;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private String pin;  // Pin asociado a la cuenta

    public Cuenta(String numeroCuenta, double saldoInicial, String pin) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.pin = pin;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) throws FondosInsuficientesException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }
        if (saldo >= monto) {
            saldo -= monto;
        } else {
            throw new FondosInsuficientesException("Fondos insuficientes");
        }
    }

    public boolean verificarPin(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }
    public boolean revisar_pin(String pin){
        return this.pin.equals(pin);
    }
}
