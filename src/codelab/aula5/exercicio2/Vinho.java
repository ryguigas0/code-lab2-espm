package codelab.aula5.exercicio2;

public class Vinho {
    private String nome;
    private int anoSafra;

    public Vinho(String nome, int anoSafra) {
        this.nome = nome;
        this.anoSafra = anoSafra;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoSafra() {
        return anoSafra;
    }

    @Override
    public String toString() {
        return "Vinho '" + nome + "' da safra de " + anoSafra;
    }
    

}
