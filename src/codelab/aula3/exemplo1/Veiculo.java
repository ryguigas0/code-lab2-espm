package codelab.aula3.exemplo1;

public class Veiculo {
    String placa;
    String marca;

    public Veiculo(String placa, String marca) {
        this.placa = placa;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return String.format("{ \"placa\": \"%s\", \"marca\": \"%s\" }", placa, marca);
    }

    @Override
    public boolean equals(Object obj) {
        Veiculo v = (Veiculo) obj;

        return v.placa.equals(this.placa) && v.marca.equals(this.marca);
    }
}