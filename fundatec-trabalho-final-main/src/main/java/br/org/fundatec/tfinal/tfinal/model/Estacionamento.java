package br.org.fundatec.tfinal.tfinal.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estacionamento")
public class Estacionamento {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String responsavel;

    public Estacionamento(){

    }

    public Estacionamento(String nome, String responsavel) {
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Estacionamento)) return false;
//        Estacionamento estacionamento = (Estacionamento) o;
//        return id.equals(estacionamento.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }


}
