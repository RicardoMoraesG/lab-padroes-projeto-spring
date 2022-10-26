package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Não há necessidade da anotação @Repository abaixo,
//  pois a classe CrudRepository já a define,
//Aqui ela está no sentido demonstrativo.
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
