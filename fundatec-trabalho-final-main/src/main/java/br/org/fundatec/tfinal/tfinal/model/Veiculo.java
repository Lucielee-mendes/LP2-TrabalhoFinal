package br.org.fundatec.tfinal.tfinal.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private TipoVeiculo tipo;
    @Column
    private String placa;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Tarifa tarifa;

    public Veiculo() {

    }

    public Veiculo(Long id, TipoVeiculo tipo, String placa, Cliente cliente, Tarifa tarifa) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
        this.cliente = cliente;
        this.tarifa = tarifa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Veiculo )) return false;
//        Veiculo veiculo = (Veiculo) o;
//        return id.equals(veiculo.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

}
