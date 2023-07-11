package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.dto.ClienteDTO;
import br.org.fundatec.tfinal.tfinal.model.Cliente;
import br.org.fundatec.tfinal.tfinal.model.Endereco;
import br.org.fundatec.tfinal.tfinal.model.Plano;
import br.org.fundatec.tfinal.tfinal.service.ClienteService;
import br.org.fundatec.tfinal.tfinal.service.EnderecoService;
import br.org.fundatec.tfinal.tfinal.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Controller
@RequestMapping(path = "/cliente")
public class ClienteCtrl {
    private final ClienteService service;
    private final EnderecoService enderecoService;
    private final PlanoService planoService;

    @Autowired
    public ClienteCtrl(ClienteService service, EnderecoService enderecoService, PlanoService planoService) {
        this.service = service;
        this.enderecoService = enderecoService;
        this.planoService = planoService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ClienteDTO clienteDTO) {
        Endereco endereco = enderecoService.findById(clienteDTO.getIdEndereco());
        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado o endereco de id " + clienteDTO.getIdEndereco());
        }
        Plano plano = planoService.findById(clienteDTO.getIdPlano());
        if (plano == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado o plano de id " + clienteDTO.getIdPlano());
        }

        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEndereco(endereco);
        cliente.setPlano(plano);
        // todo setar plano

        service.create(cliente);

        endereco.setCliente(cliente);
        enderecoService.update(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody ClienteDTO clienteDTO,
                                 @PathVariable("id") Long id) {
        Endereco endereco = enderecoService.findById(clienteDTO.getIdEndereco());
        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado o endereco de id " + clienteDTO.getIdEndereco());
        }

        Cliente cliente = service.findById(id);

        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado o cliente de id " + id);
        }
        // atualiza informações
        cliente.setCpf(clienteDTO.getCpf());

        // atualiza no banco
        service.update(cliente);
        // atualiza o endereço
        endereco.setCliente(cliente);
        enderecoService.update(endereco);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity pesquisar(@PathVariable Long id) {
        Optional<Cliente> cliente = service.pesquisar(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
