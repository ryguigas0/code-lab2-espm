package codelab.aula4.pacientes;

public class Paciente {
    private String nome;
    private int idade;
    private double pesoKG;
    private double alturaMetros;
    private double circunfQuadrilCentimetros;

    public Paciente(String nome, int idade, double pesoKG, double alturaMetros, double circunfQuadrilCentimetros) {
        this.nome = nome;
        this.idade = idade;
        this.pesoKG = pesoKG;
        this.alturaMetros = alturaMetros;
        this.circunfQuadrilCentimetros = circunfQuadrilCentimetros;
    }

    public int freqCardiacaMax() {
        return 220 - idade;
    }

    public double[] freqCardiacaAlvo() {
        int freqCardiacaMax = freqCardiacaMax();

        double[] freqCardiAlvo = new double[2];

        freqCardiAlvo[0] = 0.5 * freqCardiacaMax;
        freqCardiAlvo[1] = 0.85 * freqCardiacaMax;

        return freqCardiAlvo;
    }

    public double imc() {
        return this.pesoKG / Math.pow(alturaMetros, 2);
    }

    public double bai() {
        return (this.circunfQuadrilCentimetros / Math.pow(alturaMetros, 3 / 2)) - 18;
    }

    @Override
    public String toString() {
        return String.format(
                "NOME: %s\nFREQ CARDIACA MAX: %d\nFREQ CARDIACA ALVO: [%3.2f, %3.2f]\nIMC: %.2f\nBAI: %.2f",
                this.nome, freqCardiacaMax(), freqCardiacaAlvo()[0], freqCardiacaAlvo()[1], imc(), bai());
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Paciente) && ((Paciente) obj).nome.equalsIgnoreCase(this.nome);
    }

}
