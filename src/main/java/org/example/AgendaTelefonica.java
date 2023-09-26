package org.example;

import java.util.ArrayList;
import java.util.List;

public class AgendaTelefonica {
    private List<Contato> contatos;

    public AgendaTelefonica() {

        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(contato.getNome()) || c.getNumeroTelefone().equals(contato.getNumeroTelefone())) {
                System.out.println("Contato já existe na agenda.");
                return;
            }
        }
        contatos.add(contato);
    }

    public void removerContato(String nome) {
        Contato contatoParaRemover = null;
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatoParaRemover = contato;
                break;
            }
        }
        if (contatoParaRemover != null) {
            contatos.remove(contatoParaRemover);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public boolean atualizarContato(String nome, Contato novoContato) {
        for (int i = 0; i < contatos.size(); i++) {
            Contato contato = contatos.get(i);
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatos.set(i, novoContato);
                return true;
            }
        }
        return false;
    }


    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            System.out.println("Contatos na agenda:");
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }
}

