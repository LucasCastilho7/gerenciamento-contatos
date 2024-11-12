package model;

import java.util.HashSet;
import java.util.Set;

public class Contato implements Comparable<Contato> {

    private String nome;
    private Set<String> telefones;
    private Set<String> email;

    public Contato(String nome) {
        this.nome = nome;
        this.telefones = new HashSet<String>();
        this.email = new HashSet<String>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    public void addTelefone(String telefone) {
        this.telefones.add(telefone);
    }

    public void addEmail(String email) {
        this.email.add(email);
    }

    @Override
    public int compareTo(Contato other) {
        return this.nome.compareTo(other.nome);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", telefones=" + telefones +
                ", email=" + email +
                '}';
    }
}