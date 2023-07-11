package br.org.fundatec.tfinal.tfinal.service;

import br.org.fundatec.tfinal.tfinal.dto.TarifaDTO;
import br.org.fundatec.tfinal.tfinal.dto.VeiculoDTO;
import br.org.fundatec.tfinal.tfinal.model.Tarifa;
import br.org.fundatec.tfinal.tfinal.model.Veiculo;
import br.org.fundatec.tfinal.tfinal.repository.TarifaRepository;
import br.org.fundatec.tfinal.tfinal.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstacionamentoService {
    private final VeiculoRepository veiculoRepository;
    private final TarifaRepository tarifarepository;

    public EstacionamentoService(VeiculoRepository veiculoRepository, TarifaRepository tarifarepository) {
        this.veiculoRepository = veiculoRepository;
        this.tarifarepository = tarifarepository;
    }

    public void registrarVeiculo(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(veiculoDTO.getPlaca());
        veiculo.setTipo(veiculoDTO.getTipo());
        veiculoRepository.save(veiculo);
    }

    public VeiculoDTO consultarVeiculo(String placa) {
        Veiculo veiculo = veiculoRepository.findFirstByPlaca(placa);
        if (veiculo != null) {
            VeiculoDTO veiculoDTO = new VeiculoDTO();
            veiculoDTO.setPlaca(veiculo.getPlaca());
            veiculoDTO.setTipo(veiculo.getTipo());
            return veiculoDTO;
        }
        return null;
    }
    public void atualizarTarifa(TarifaDTO tarifaDTO) {
        Optional<Tarifa> optionalTarifa = tarifarepository.findById(tarifaDTO.getId());
        if (optionalTarifa.isPresent()) {
            Tarifa tarifa = optionalTarifa.get();
            tarifa.setValorPago(tarifaDTO.getValorPago());

            tarifarepository.save(tarifa);
        } else {

        }
    }


}
