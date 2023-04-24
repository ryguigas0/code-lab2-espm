package codelab.aula5.fila.exercicio1;

public class LoteAcoes {
    private double valorAcao;
    private int quantidade;

    public LoteAcoes(int quantidade, double valorAcao) {
        this.valorAcao = valorAcao;
        this.quantidade = quantidade;
    }

    public double getValorAcao() {
        return valorAcao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "LoteAcoes [valorAcao=" + valorAcao + ", quantidade=" + quantidade + "]";
    }
}
