package br.org.fundatec.tfinal.tfinal.dto;

import java.time.LocalDateTime;

public class TarifaDTO {
    private Long id;
    private Long veiculoId;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Double valorPago;
    private Long estacionamentoId;

    public TarifaDTO() {

    }

    public TarifaDTO(Long id, Long veiculoId, LocalDateTime entrada, LocalDateTime saida, Double valorPago, Long estacionamentoId) {
        this.id = id;
        this.veiculoId = veiculoId;
        this.entrada = entrada;
        this.saida = saida;
        this.valorPago = valorPago;
        this.estacionamentoId = estacionamentoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Long getEstacionamentoId() {
        return estacionamentoId;
    }

    public void setEstacionamentoId(Long estacionamentoId) {
        this.estacionamentoId = estacionamentoId;
    }
}

