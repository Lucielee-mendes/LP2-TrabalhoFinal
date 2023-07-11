package br.org.fundatec.tfinal.tfinal.dto;

import br.org.fundatec.tfinal.tfinal.model.Plano;

public class ClienteDTO {
    private String cpf;
    private Long idEndereco;
    private Long idPlano;


    public ClienteDTO(String cpf, Long idEndereco, Long idPlano) {
        this.cpf = cpf;
        this.idEndereco = idEndereco;
        this.idPlano = idPlano;
    }

    public ClienteDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Long getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Long idPlano) {
        this.idPlano = idPlano;
    }
}
