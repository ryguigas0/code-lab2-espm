package codelab.aula2.exemplo1;

public class Veiculo {
    String placa;
    String marca;

    public Veiculo(String placa, String marca) {
        this.placa = placa;
        this.marca = marca;
    }

    @Override
    public String toString() {
        String out = String.format("{ \"placa\": \"%s\", \"marca\": \"%s\" }", placa, marca);
        return out;
    }
}