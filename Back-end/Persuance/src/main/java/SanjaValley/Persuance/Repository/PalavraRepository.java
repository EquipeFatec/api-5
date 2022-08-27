package SanjaValley.Persuance.Repository;

import SanjaValley.Persuance.Entity.Palavra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PalavraRepository extends JpaRepository<Palavra, Long> {

    public List<Palavra> findByPalavra(String palavra);

}
