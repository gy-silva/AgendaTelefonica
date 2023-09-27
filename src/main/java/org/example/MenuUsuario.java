package org.example;

import java.util.Scanner;

public class MenuUsuario {

    public void menu(){
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Atualizar Contato");
            System.out.println("5. Listar Contatos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try{

             int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do contato: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine().toUpperCase();
                    System.out.print("Digite o número de telefone: ");
                    String numeroTelefone = scanner.nextLine();
                    Contato novoContato = new Contato(nome, numeroTelefone);
                    agenda.adicionarContato(novoContato);
                    System.out.println("Contato adicionado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    scanner.nextLine();
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContato(nomeRemover);
                    System.out.println("Contato removido com sucesso.");
                    break;
                case 3:
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    scanner.nextLine();
                    String nomeBuscar = scanner.nextLine().toUpperCase();
                    Contato contatoEncontrado = agenda.buscarContato(nomeBuscar);
                    if (contatoEncontrado != null) {
                        System.out.println("Contato encontrado: " + contatoEncontrado);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do contato a ser atualizado: ");
                    scanner.nextLine();
                    String nomeAtualizar = scanner.nextLine().toUpperCase();
                    System.out.print("Digite o novo número de telefone: ");
                    String novoNumeroTelefone = scanner.nextLine();

                    Contato novoContatoAtualizado = new Contato(nomeAtualizar, novoNumeroTelefone);

                    if (agenda.atualizarContato(nomeAtualizar, novoContatoAtualizado)) {
                        System.out.println("Contato atualizado com sucesso.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 5:
                    agenda.listarContatos();
                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            } catch (java.util.InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            }
        }

    }
}
