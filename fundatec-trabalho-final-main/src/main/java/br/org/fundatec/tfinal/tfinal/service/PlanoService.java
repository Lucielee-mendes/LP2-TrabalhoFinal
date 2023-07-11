package br.org.fundatec.tfinal.tfinal.service;

import br.org.fundatec.tfinal.tfinal.dto.ClienteDTO;
import br.org.fundatec.tfinal.tfinal.dto.PlanoDTO;
import br.org.fundatec.tfinal.tfinal.model.Cliente;
import br.org.fundatec.tfinal.tfinal.model.Plano;
import br.org.fundatec.tfinal.tfinal.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanoService {
    private final PlanoRepository planoRepository;
    private final EnderecoService enderecoService;

    @Autowired
    public PlanoService(PlanoRepository planoRepository, EnderecoService enderecoService) {
        this.planoRepository = planoRepository;
        this.enderecoService = enderecoService;
    }

    public PlanoDTO findPlanoByClienteId(Long clienteId) {
        Plano plano = planoRepository.findByAssinanteId(clienteId);
        if (plano == null) {
            return null;
        }
        PlanoDTO dto = new PlanoDTO();
        dto.setValor(plano.getValor());
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCpf(plano.getAssinante().getCpf());
        clienteDTO.setIdEndereco(plano.getAssinante().getEndereco().getId());
        dto.setCliente(clienteDTO);
        return planoRepository.findPlanoDTOByAssinanteId(clienteId);
    }

    public void create(Plano planoEntity) {
        planoRepository.save(planoEntity);
    }

    public Plano findById(Long idPlano) {
        return planoRepository.findById(idPlano).orElse(null);
    }

    public void cadastrarPlano(PlanoDTO planoDTO) {
        Plano plano = new Plano();
        plano.setValor(planoDTO.getValor());

        Cliente cliente = new Cliente();
        cliente.setCpf(planoDTO.getCliente().getCpf());
        cliente.setEndereco(enderecoService.findById(planoDTO.getCliente().getIdEndereco()));
        plano.setAssinante(cliente);

        planoRepository.save(plano);

    }

    public void recarregarCreditoPlanoAssinante(Long planoAssinanteId, Double valorRecarga) {
        Optional<Plano> optionalPlano = planoRepository.findById(planoAssinanteId);

        if (optionalPlano.isPresent()) {
            Plano plano = optionalPlano.get();
            Double novoValor = plano.getValor() + valorRecarga;
            plano.setValor(novoValor);
            planoRepository.save(plano);
        } else {

        }

    }
}
