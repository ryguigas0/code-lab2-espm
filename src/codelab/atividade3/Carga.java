package codelab.atividade3;

import java.util.Random;

public class Carga {
    private int id;
    private String cnpjEmpresa;
    private String nomeEmpresa;
    private String destino;
    private double pesoTotal; // kg

    public Carga(String cnpjEmpresa, String nomeEmpresa, String destino, double pesoTotal) {
        this.id = gerarID();
        this.cnpjEmpresa = cnpjEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.destino = destino;
        this.pesoTotal = pesoTotal;
    }

    private int gerarID() {
        Random r = new Random();
        int numero = r.nextInt(999999);
        return numero;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d\nCPNJ EMPRESA: %s\nNOME EMPRESA: %s\nDESTINO: %s\nPESO TOTAL: %.2fkg",
                id, cnpjEmpresa, nomeEmpresa, destino, pesoTotal);

    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass()) && ((Carga) obj).cnpjEmpresa.equals(this.cnpjEmpresa);
    }

    public int getId() {
        return id;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }
}
