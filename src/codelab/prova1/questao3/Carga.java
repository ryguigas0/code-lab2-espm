package codelab.prova1.questao3;

public class Carga {
    String cnpjEmpresa;
    String nomeEmpresa;
    String destino;
    double pesoTotal; // kg

    public Carga(String cnpjEmpresa, String nomeEmpresa, String destino, double pesoTotal) {
        this.cnpjEmpresa = cnpjEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.destino = destino;
        this.pesoTotal = pesoTotal;
    }

    @Override
    public String toString() {
        return String.format(
                "CPNJ EMPRESA: %s\nNOME EMPRESA: %s\nDESTINO: %s\nPESO TOTAL: %.2fkg",
                cnpjEmpresa, nomeEmpresa, destino, pesoTotal);

    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass()) && ((Carga) obj).cnpjEmpresa.equals(this.cnpjEmpresa);
    }

}
