package br.org.fundatec.tfinal.tfinal.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tarifa")
public class Tarifa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name="fk_veiculo")
    @ManyToOne
    private Veiculo veiculo;
    @Column(name = "entrada")
    private LocalDateTime entrada;
    @Column(name = "saida")
    private LocalDateTime saida;
    @Column(name = "valor_pago")
    private Double valorPago;

    @ManyToOne
    @JoinColumn(name = "estacionamento_id")
    private Estacionamento estacionamento;

    public Tarifa() {

    }

    public Tarifa(Long id, Veiculo veiculo, LocalDateTime entrada, LocalDateTime saida, Double valorPago, Estacionamento estacionamento) {
        this.id = id;
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
        this.valorPago = valorPago;
        this.estacionamento = estacionamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }



}
