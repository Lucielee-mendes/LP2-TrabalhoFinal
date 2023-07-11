package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.dto.*;
import br.org.fundatec.tfinal.tfinal.service.ClienteService;
import br.org.fundatec.tfinal.tfinal.service.EnderecoService;
import br.org.fundatec.tfinal.tfinal.service.EstacionamentoService;
import br.org.fundatec.tfinal.tfinal.service.PlanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoCtrl {
    private final EstacionamentoService estacionamentoService;
    private final PlanoService planoService;
    private final EnderecoService enderecoService;
    private final ClienteService clienteService;


    public EstacionamentoCtrl(EstacionamentoService estacionamentoService, PlanoService planoService, EnderecoService enderecoService, ClienteService clienteService) {
        this.estacionamentoService = estacionamentoService;
        this.planoService = planoService;
        this.enderecoService = enderecoService;
        this.clienteService = clienteService;
    }

    @PostMapping("/veiculo")
    public ResponseEntity<String> registrarVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        try {
            estacionamentoService.registrarVeiculo(veiculoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/veiculo/{placa}")
    public ResponseEntity<VeiculoDTO> consultarVeiculo(@PathVariable("placa") String placa) {
        VeiculoDTO veiculoDTO = estacionamentoService.consultarVeiculo(placa);
        if (veiculoDTO != null) {
            return ResponseEntity.ok(veiculoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tarifa")
    public ResponseEntity<String> atualizarTarifa(@RequestBody TarifaDTO tarifaDTO) {
        try {
            estacionamentoService.atualizarTarifa(tarifaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping("/plano")
    public ResponseEntity<String> cadastrarPlanoAssinante(@RequestBody PlanoDTO planoDTO) {
        planoService.cadastrarPlano(planoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Plano de assinante cadastrado com sucesso.");
    }

    @PostMapping("/plano/{id}/recarga")
    public ResponseEntity<String> recarregarCreditoPlanoAssinante(@PathVariable("id") Long planoAssinanteId,
                                                                  @RequestParam("valor") Double valorRecarga) {
        planoService.recarregarCreditoPlanoAssinante(planoAssinanteId, valorRecarga);
        return ResponseEntity.ok("Recarga de crédito realizada com sucesso.");
    }

    // Métodos para manipulação de endereços, clientes, etc.

    @PostMapping("/endereco")
    public ResponseEntity<String> cadastrarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        enderecoService.cadastrarEndereco(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço cadastrado com sucesso.");
    }

    @PostMapping("/cliente")
    public ResponseEntity<String> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso.");
    }


}

