package br.org.fundatec.tfinal.tfinal.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_TarifaPorTipo")
public class TarifaPorTipo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private Double taxaAteMeiaHora;
    @Column
    private Double taxaAteUmaHora;
    @Column
    private Double taxaHoraAdicional;
    @Column
    private Double taxaDiaria;
    @Column
    private TipoVeiculo tipoVeiculo;

    public TarifaPorTipo(){

    }

    public TarifaPorTipo(Long id, Double taxaAteMeiaHora, Double taxaAteUmaHora, Double taxaHoraAdicional, Double taxaDiaria, TipoVeiculo tipoVeiculo) {
        Id = id;
        this.taxaAteMeiaHora = taxaAteMeiaHora;
        this.taxaAteUmaHora = taxaAteUmaHora;
        this.taxaHoraAdicional = taxaHoraAdicional;
        this.taxaDiaria = taxaDiaria;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Double getTaxaAteMeiaHora() {
        return taxaAteMeiaHora;
    }

    public void setTaxaAteMeiaHora(Double taxaAteMeiaHora) {
        this.taxaAteMeiaHora = taxaAteMeiaHora;
    }

    public Double getTaxaAteUmaHora() {
        return taxaAteUmaHora;
    }

    public void setTaxaAteUmaHora(Double taxaAteUmaHora) {
        this.taxaAteUmaHora = taxaAteUmaHora;
    }

    public Double getTaxaHoraAdicional() {
        return taxaHoraAdicional;
    }

    public void setTaxaHoraAdicional(Double taxaHoraAdicional) {
        this.taxaHoraAdicional = taxaHoraAdicional;
    }

    public Double getTaxaDiaria() {
        return taxaDiaria;
    }

    public void setTaxaDiaria(Double taxaDiaria) {
        this.taxaDiaria = taxaDiaria;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof TarifaPorTipo)) return false;
//        TarifaPorTipo tarifaPorTipo = (TarifaPorTipo) o;
//        return Id.equals(tarifaPorTipo.Id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(Id);
//    }
}

