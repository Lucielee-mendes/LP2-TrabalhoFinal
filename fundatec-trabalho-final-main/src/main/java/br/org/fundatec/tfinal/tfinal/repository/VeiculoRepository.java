package br.org.fundatec.tfinal.tfinal.repository;

import br.org.fundatec.tfinal.tfinal.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Veiculo findFirstByPlaca(String placa);
}