package br.org.fundatec.tfinal.tfinal.service;

import br.org.fundatec.tfinal.tfinal.dto.TarifaDTO;
import br.org.fundatec.tfinal.tfinal.model.Tarifa;
import br.org.fundatec.tfinal.tfinal.model.TarifaPorTipo;
import br.org.fundatec.tfinal.tfinal.model.Veiculo;
import br.org.fundatec.tfinal.tfinal.repository.TarifaRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TarifaService {

    private final TarifaRepository tarifaRepository;

    public TarifaService(TarifaRepository tarifaRepository) {
        this.tarifaRepository = tarifaRepository;
    }

    public void atualizarTarifa(TarifaDTO tarifaDTO) {
        Optional<Tarifa> optionalTarifa = tarifaRepository.findById(tarifaDTO.getId());
        if (optionalTarifa.isPresent()) {
            Tarifa tarifa = optionalTarifa.get();
            // Atualize os atributos da tarifa com base nos dados do DTO
            tarifa.setEntrada(tarifaDTO.getEntrada());
            tarifa.setSaida(tarifaDTO.getSaida());
            tarifa.setValorPago(tarifaDTO.getValorPago());
            tarifaRepository.save(tarifa);
        } else {

        }
    }

    public Tarifa salvar(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    public void delete(Long id) {
        tarifaRepository.deleteById(id);
    }

    public Tarifa atualizar(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    public Optional<Tarifa> findById(Long id) {
        return tarifaRepository.findById(id);
    }

    public Iterable<Tarifa> findAll() {
        return tarifaRepository.findAll();
    }


    public Tarifa registrarEntradaVeiculo(Veiculo veiculo, LocalDateTime entrada) {
        Tarifa tarifa = new Tarifa();
        tarifa.setVeiculo(veiculo);
        tarifa.setEntrada(entrada);
        // Defina outros atributos da tarifa, se necessário
        return tarifaRepository.save(tarifa);
    }

    public void registrarSaidaVeiculo(Tarifa tarifa, LocalDateTime saida) {
        tarifa.setSaida(saida);
        // Atualize outros atributos da tarifa, se necessário
        tarifaRepository.save(tarifa);
    }
    public Double calcularTarifa(Tarifa tarifa, TarifaPorTipo tarifaTipo) {
        LocalDateTime entrada = tarifa.getEntrada();
        LocalDateTime saida = tarifa.getSaida();

        Duration duracao = Duration.between(entrada, saida);
        long horas = duracao.toHours();

        double tarifaTotal = 0.0;
        if (horas <= 0) {
            tarifaTotal = 0.0; // Nenhuma tarifa se a permanência for negativa ou zero
        } else if (horas <= 0.5) {
            tarifaTotal = tarifaTipo.getTaxaAteMeiaHora();
        } else if (horas <= 1) {
            tarifaTotal = tarifaTipo.getTaxaAteUmaHora();
        } else {
            tarifaTotal = tarifaTipo.getTaxaAteUmaHora() + (horas - 1) * tarifaTipo.getTaxaHoraAdicional();
        }

        return tarifaTotal;
    }

}
