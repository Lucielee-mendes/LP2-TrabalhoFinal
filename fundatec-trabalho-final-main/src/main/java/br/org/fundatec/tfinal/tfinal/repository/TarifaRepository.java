package br.org.fundatec.tfinal.tfinal.repository;

import br.org.fundatec.tfinal.tfinal.model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {

}
