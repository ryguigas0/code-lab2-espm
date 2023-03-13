package codelab.aula3.exemplo2;

public class Main {
    public static void main(String[] args) {
        ListaDuplaGenerica<Conta> listaDuplaConta = new ListaDuplaGenerica<Conta>();

        listaDuplaConta.inserirInicio(new Conta("Guilherme"));

        System.out.println(listaDuplaConta);

        listaDuplaConta.inserirInicio(new Conta("Ponzio"));

        System.out.println(listaDuplaConta);

        listaDuplaConta.inserirFim(new Conta("Ana"));

        System.out.println(listaDuplaConta);

        listaDuplaConta.inserirFim(new Conta("Vinicius"));

        System.out.println(listaDuplaConta);

        System.out.println("Busca impossível: " + listaDuplaConta.pesquisar(new Conta("Roberto")));

        System.out.println("Busca possível: " + listaDuplaConta.pesquisar(new Conta("Guilherme")));

        listaDuplaConta.deletar(new Conta("Guilherme"));

        System.out.println(listaDuplaConta);

        listaDuplaConta.deletar(new Conta("Ponzio"));

        System.out.println(listaDuplaConta);

        listaDuplaConta.deletar(new Conta("Vinicius"));

        System.out.println(listaDuplaConta);

        listaDuplaConta.deletar(new Conta("Ana"));

        System.out.println(listaDuplaConta);

    }
}
