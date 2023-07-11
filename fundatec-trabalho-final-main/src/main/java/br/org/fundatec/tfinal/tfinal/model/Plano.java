package br.org.fundatec.tfinal.tfinal.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Plano  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100, name = "id_Plano")
    private Long id;

    @Column(nullable = false, length = 5, name = "Valor")
    private Double valor;

    @OneToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente assinante;

    private Boolean isAsssinante;

    public Plano() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getAssinante() {
        return assinante;
    }

    public void setAssinante(Cliente assinante) {
        this.assinante = assinante;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Plano)) return false;
//        Plano plano = (Plano) o;
//        return id.equals(plano.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
