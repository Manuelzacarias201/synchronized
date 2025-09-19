import models.CuentaProtegida;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        CuentaProtegida cuenta = new CuentaProtegida(1000);

        Thread h1 = new Thread(() -> cuenta.depositar(200), "Hilo-200");
        Thread h2 = new Thread(() -> cuenta.depositar(300), "Hilo-300");
        Thread h3 = new Thread(() -> cuenta.depositar(500), "Hilo-500");

        h1.start();
        h2.start();
        h3.start();

        h1.join();
        h2.join();
        h3.join();

        System.out.println("Saldo inicial: $1000");
        System.out.println("Saldo esperado: $2000");
        System.out.println("Saldo real (con sync): $" + cuenta.getSaldo());
    }
}
