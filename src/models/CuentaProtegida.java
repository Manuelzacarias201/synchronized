package models;

public class CuentaProtegida {
    private int saldo;

    public CuentaProtegida(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Bloque synchronized para evitar inconsistencia
    public void depositar(int cantidad) {
        synchronized (this) {
            saldo += cantidad;
        }
    }

    public int getSaldo() {
        synchronized (this) {
            return saldo;
        }
    }
}
