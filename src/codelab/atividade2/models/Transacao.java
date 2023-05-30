package codelab.atividade2.models;

public class Transacao {
    private String nome;
    private int codigo;
    private int tempo; // segundos

    public Transacao(int codigo) {
        switch (codigo) {
            case 0:
                this.nome = "Saldo";
                this.tempo = 10;
                break;
            case 1:
                this.nome = "Saque";
                this.tempo = 20;
                break;
            case 2:
                this.nome = "Aplicação";
                this.tempo = 30;
                break;
            case 3:
                this.nome = "Extrato semanal";
                this.tempo = 40;
                break;
            case 4:
                this.nome = "Extrato mensal";
                this.tempo = 50;
                break;
            case 5:
                this.nome = "Pagamento de conta com dinheiro";
                this.tempo = 60;
                break;
            case 6:
                this.nome = "Pagamento de conta com cheque";
                this.tempo = 70;
                break;
            case 7:
                this.nome = "Pagamento de conta com saque";
                this.tempo = 80;
                break;
            default:
                throw new RuntimeException("Código de transação inválido!");
        }

        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getTempo() {
        return tempo;
    }

}
