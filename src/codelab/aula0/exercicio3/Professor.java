package codelab.aula0.exercicio3;

class Professor {
    String nome;
    double valorAula;
    int quantidadeAulasSemanais;

    public double salarioBase() {
        return quantidadeAulasSemanais * 4.5 * valorAula;
    }

    public double adicionalHoraAtividade() {
        return 1.05 * salarioBase();
    }

    public double descansoSemanalRemunerado() {
        return (salarioBase() + adicionalHoraAtividade()) * (1 + (1 / 6));
    }

    public static Professor criarProfessor(String nome, double valorAula, int quantidadeAulasSemanais) {
        Professor p = new Professor();

        p.nome = nome;

        p.valorAula = valorAula;

        p.quantidadeAulasSemanais = quantidadeAulasSemanais;

        return p;
    }

    public void printarProfessor() {
        System.out.println("---------------------------------");
        System.out.println("NOME: " + nome);
        System.out.println("VAL AULA: " + String.format("R$%.2f / hora", valorAula));
        System.out.println("QUANTIDADE AULAS SEMANAIS: " + quantidadeAulasSemanais);
        System.out.println("SALARIO BASE: " + String.format("R$%.2f", salarioBase()));
        System.out.println("ADICIONAL HORA ATIVIDADE: " + String.format("R$%.2f",
                adicionalHoraAtividade()));
        System.out.println("DESCANSO SEMANAL REMUNERADO: " + String.format("R$%.2f",
                descansoSemanalRemunerado()));
        System.out.println("---------------------------------");
    }
}