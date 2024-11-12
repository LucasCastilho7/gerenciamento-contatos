import model.Contato;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class GerenciadorContatos {

    private List<Contato> contatos;
    private Set<String> telefoneContatos;
    private TreeMap<Contato, String> alphabeticalContatos;

    public GerenciadorContatos() {
        this.contatos = new ArrayList<Contato>();
        this.telefoneContatos = new HashSet<String>();
        this.alphabeticalContatos = new TreeMap<Contato, String>();
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public Set<String> getTelefoneContatos() {
        return telefoneContatos;
    }

    public void setTelefoneContatos(Set<String> telefoneContatos) {
        this.telefoneContatos = telefoneContatos;
    }

    public TreeMap<Contato, String> getAlphabeticalContatos() {
        return alphabeticalContatos;
    }

    public void setAlphabeticalContatos(TreeMap<Contato, String> alphabeticalContatos) {
        this.alphabeticalContatos = alphabeticalContatos;
    }

    public void populateAlphabeticalContatos() {
        if (contatos.isEmpty()) throw new RuntimeException("Não há contatos na lista.");

        for (Contato contato : contatos) {
            alphabeticalContatos.put(contato, contato.getNome());
        }
    }

    public String adicionarContato(Contato contato) {
        for (String telefone : contato.getTelefones()) {
            if (telefoneContatos.contains(telefone)) {
                return "Telefone já cadastrado: " + telefone;
            }
        }

        contatos.add(contato);
        telefoneContatos.addAll(contato.getTelefones());
        alphabeticalContatos.put(contato, contato.getNome());
        return "Contato adicionado com sucesso.";
    }

    public String buscarPorNome(String nome) {
        for (Contato contato : alphabeticalContatos.keySet()) {
            if (contato.getNome().equals(nome)) {
                return String.format("Contato encontrado: %s", contato);
            }
        }
        return null;
    }

    public String buscarPorTelefone(String telefone) {
        for (Contato contato : contatos) {
            if (contato.getTelefones().contains(telefone)) {
                return String.format("Contato encontrado: %s", contato);
            }
        }
        return "Contato não encontrado.";
    }

    public List<Contato> listarTodosContatos() {
        return new ArrayList<>(alphabeticalContatos.keySet());
    }

    public String removerContato(Contato contato) {
        if (contatos.remove(contato)) {
            telefoneContatos.removeAll(contato.getTelefones());
            alphabeticalContatos.remove(contato);
            return "Contato removido com sucesso.";
        }
        return "Contato não encontrado.";
    }

    public static void main(String[] args) {
        GerenciadorContatos gerenciador = new GerenciadorContatos();

        Contato contato1 = new Contato("Lucas");
        contato1.addTelefone("123456789");
        contato1.addEmail("lucas@gmail.com");
    
        Contato contato2 = new Contato("Gabriele");
        contato2.addTelefone("987654321");
        contato2.addEmail("gabi@gmail.com");
    
        Contato contato3 = new Contato("Brenno");
        contato3.addTelefone("555555555");
        contato3.addEmail("brenno@gmail.com");

        System.out.println(gerenciador.adicionarContato(contato1));
        System.out.println(gerenciador.adicionarContato(contato2));
        System.out.println(gerenciador.adicionarContato(contato3));

        Contato contato4 = new Contato("David");
        contato4.addTelefone("123456789");
        System.out.println(gerenciador.adicionarContato(contato4));

        gerenciador.populateAlphabeticalContatos();

        System.out.println(gerenciador.buscarPorNome("Lucas"));
        System.out.println(gerenciador.buscarPorNome("Gabriele"));

        System.out.println(gerenciador.buscarPorTelefone("987654321"));
        System.out.println(gerenciador.buscarPorTelefone("111111111"));

        System.out.println(gerenciador.listarTodosContatos());

        System.out.println(gerenciador.removerContato(contato2));
        System.out.println(gerenciador.removerContato(contato2));

        System.out.println(gerenciador.listarTodosContatos());
    }
}