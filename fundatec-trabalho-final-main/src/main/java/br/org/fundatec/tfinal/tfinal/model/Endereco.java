package br.org.fundatec.tfinal.tfinal.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Endereco {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String rua;
    @Column(length = 8, name = "Numero")
    private Integer numero;

    @Column(length = 50, name = "Cidade")
    private String cidade;
    @Column(length = 20, name = "Estado")
    private String estado;
    @Column(length = 50, name = "Bairro")
    private String bairro;
    @Column(length = 8)
    private String cep;

    @OneToOne
    @JoinColumn(name = "cliente_endereco")
    private Cliente cliente;

    public Endereco() {
        this.id = id;
        this.cliente = cliente;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Endereco)) return false;
//        Endereco endereco = (Endereco) o;
//        return id == endereco.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}


