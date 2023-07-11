package br.org.fundatec.tfinal.tfinal.service;

import br.org.fundatec.tfinal.tfinal.model.Veiculo;
import br.org.fundatec.tfinal.tfinal.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }
    public Veiculo salvar(Veiculo veiculo) {
        return this.veiculoRepository.save(veiculo);
    }

    public Veiculo atualizar(Veiculo veiculo) {
        return this.veiculoRepository.save(veiculo);
    }


    public Optional<Veiculo> findById(Long id) {
        return this.veiculoRepository.findById(id);
    }

    public Iterable<Veiculo> findAll() {
        return this.veiculoRepository.findAll();
    }

    public Optional<Veiculo> findByLike(Long id) {
        return this.veiculoRepository.findById(id);
    }

    public void delete(Long id) {
        this.veiculoRepository.deleteById(id);
    }


}
