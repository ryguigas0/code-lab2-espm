package codelab.aula0.exercicio2;

public class Main {
    public static void main(String[] args) {
        Cliente c = Cliente.criarCliente("Guilherme Casagrande");

        c.consultarSaldo();

        c.deposito(200);

        c.consultarSaldo();

        c.saque(300);

        c.consultarSaldo();

        c.saque(100);

        c.consultarSaldo();
    }
}
