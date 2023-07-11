package br.org.fundatec.tfinal.tfinal.repository;

import br.org.fundatec.tfinal.tfinal.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
