package codelab.trabalho1;

import static javax.swing.JOptionPane.*;

public class Sistema {
    Database db = new Database();
    double valorPassagem = 4.4;

    public void iniciar() {
        loopInicial();
    }

    private void loopInicial() {
        int opcao;
        boolean alive = true;
        do {
            opcao = dialogoOpcoes(new String[] { "Administrador", "Usuario", "Finalizar" });
            switch (opcao) {
                case 1:
                    alive = loopAdministrador();
                    break;
                case 2:
                    alive = loopUsuario();
                    break;
                case 3:
                    alive = false;
                    break;

                default:
                    showMessageDialog(null, "Por favor selecione uma opção válida");
                    break;
            }
        } while (alive);
    }

    private boolean loopAdministrador() {
        int opcao;
        do {
            opcao = dialogoOpcoes(new String[] { "Cadastrar bilhete", "Consultar bilhete", "Listar Bilhete", "Sair" });

            Usuario usuario;

            switch (opcao) {
                case 1:
                    usuario = cadastrarUsuario();
                    if (usuario != null) {
                        cadastrarBilhete(usuario);
                    }
                    break;
                case 2:
                    String message = "Bilhete único não encontrado!";
                    usuario = encontrarUsuario();
                    if (usuario != null) {
                        BilheteUnico bilheteUnico = encontrarBilheteUnico(usuario);
                        message = bilheteUnico.toString();
                    }
                    showMessageDialog(null, message);
                    break;
                case 4:
                    return false;

                default:
                    showMessageDialog(null, "Digite uma opção válida");
                    break;
            }
        } while (true);
    }

    private Usuario encontrarUsuario() {
        String cpf = showInputDialog(null, "Digite o cpf do usuário");

        return db.encontrarUsuario(cpf);
    }

    private BilheteUnico encontrarBilheteUnico(Usuario usuario) {
        return db.encontrarBilheteUnico(usuario);
    }

    private void cadastrarBilhete(Usuario usuario) {

        double valorDaTarifa = 4.4;

        if (usuario.getTipoDeTarifa().equals("estudante") || usuario.getTipoDeTarifa().equals("professor")) {
            valorDaTarifa = valorDaTarifa * 0.5;
        }

        BilheteUnico resultado = null;
        do {
            resultado = db.inserirBilhete(valorDaTarifa, usuario);
        } while (resultado == null);
    }

    private Usuario cadastrarUsuario() {
        String nome = showInputDialog(null, "Digite o nome do usuario dono do bilhete único");

        String cpf = showInputDialog(null, "Digite o cpf do usuario dono do bilhete único");

        String tipoDeTarifa = dialogoOpcoesValor(new String[] { "Estudante", "Professor", "Normal" },
                new String[] { "estudante", "professor", "normal" });

        Usuario newUsuario = db.inserirUsuario(new Usuario(nome, cpf, tipoDeTarifa));
        if (newUsuario != null) {
            showMessageDialog(null, "Usuário \"" + nome + "\" foi inserido!");

        } else {
            showMessageDialog(null, "Erro inserindo usuário \"" + nome + "\"!");
        }

        return newUsuario;
    }

    private boolean loopUsuario() {
        int opcao;
        do {
            opcao = dialogoOpcoes(new String[] { "Consultar saldo", "Carregar bilhete", "Passar na catraca", "Sair" });

            switch (opcao) {
                case 4:
                    return false;

                default:
                    showMessageDialog(null, "Digite uma opção válida");
                    break;
            }
        } while (true);
    }

    private int dialogoOpcoes(String[] opcoes) {
        String message = "";

        for (int i = 0; i < opcoes.length; i++) {
            message += (i + 1) + " - " + opcoes[i] + "\n";
        }

        return Integer.parseInt(showInputDialog(null, message));
    }

    private String dialogoOpcoesValor(String[] opcoes, String[] valores) {
        int opcao = dialogoOpcoes(opcoes);

        return valores[opcao - 1];
    }
}
