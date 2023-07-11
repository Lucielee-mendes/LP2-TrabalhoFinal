package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.model.Tarifa;
import br.org.fundatec.tfinal.tfinal.service.TarifaService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class TarifaCtrl {

    private final TarifaService tarifaService;

    public TarifaCtrl(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    @PostMapping
    public Tarifa salvar(@RequestBody Tarifa tarifa) {
        return tarifaService.salvar(tarifa);
    }

    @PutMapping
    public Tarifa atualizar(@RequestBody Tarifa tarifa) {
        return tarifaService.atualizar(tarifa);
    }

    @GetMapping("/{id}")
    public Tarifa findTarifaById(@PathVariable Long id) {
        Optional<Tarifa> optionalTax = tarifaService.findById(id);
        if (optionalTax.isPresent())
            return optionalTax.get();

        return null;
    }

    @GetMapping
    public Iterable<Tarifa> findAll() {
        return tarifaService.findAll();
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tarifaService.delete(id);
    }

}
