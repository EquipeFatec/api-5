package SanjaValley.Persuance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SanjaValley.Persuance.Entity.Palavra;

public interface PalavraRepository extends JpaRepository<Palavra, Long> {

    //Usado no caso do adm, vai retornar todas as revisões da palavra
    public List<Palavra> findByPalavra(String palavra);

    //Usado no caso de user, retorna a palavra que está na ULTIMA revisao
    public List<Palavra> findByPalavraOrderByRevisaoDesc(String palavra);

    //Usado no caso do adm adicionar nova palavra, retorna a ultima revisao da palavra a ser inserida e a classe gramatical que ela pertence
    public List<Palavra> findByPalavraAndClasseGramaticalOrderByRevisaoDesc(String palavra, String classeGramatical);

}
