package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.model.Veiculo;
import br.org.fundatec.tfinal.tfinal.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Veiculo")
public class VeiculoCtrl {

    private final VeiculoService veiculoService;

    public VeiculoCtrl(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;

    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @PutMapping
    public Veiculo atualizar(@RequestBody Veiculo veiculo) {
        return veiculoService.atualizar(veiculo);
    }

    @GetMapping("/{id}")
    public Veiculo findVehicleById(@PathVariable Long id) {
        Optional<Veiculo> optionalVehicle = veiculoService.findById(id);
        if (optionalVehicle.isPresent())
            return optionalVehicle.get();

        return null;
    }

    @GetMapping
    public Iterable<Veiculo> findAll() {
        return veiculoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        veiculoService.delete(id);
    }


}
