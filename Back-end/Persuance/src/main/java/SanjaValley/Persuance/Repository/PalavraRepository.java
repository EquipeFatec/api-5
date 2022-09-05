package SanjaValley.Persuance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SanjaValley.Persuance.entity.Palavra;

public interface PalavraRepository extends JpaRepository<Palavra, Long> {

    public List<Palavra> findByPalavra(String palavra);

}
