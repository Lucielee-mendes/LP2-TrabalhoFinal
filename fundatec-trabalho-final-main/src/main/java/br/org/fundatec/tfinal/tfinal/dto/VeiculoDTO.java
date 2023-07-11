package br.org.fundatec.tfinal.tfinal.dto;

import br.org.fundatec.tfinal.tfinal.model.TipoVeiculo;

public class VeiculoDTO {
    private String placa;
    private TipoVeiculo tipo;

    public VeiculoDTO() {
    }

    public VeiculoDTO(String placa, TipoVeiculo tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }
}

