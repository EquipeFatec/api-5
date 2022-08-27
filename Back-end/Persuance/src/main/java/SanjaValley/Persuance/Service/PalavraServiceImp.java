package SanjaValley.Persuance.Service;

import SanjaValley.Persuance.Entity.Palavra;
import SanjaValley.Persuance.Repository.PalavraRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PalavraServiceImp implements PalavraService{

    @Autowired
    private PalavraRepository palavraRepository;


    @Override
    public Palavra novaPalavra(Palavra palavra) {

        return palavraRepository.save(palavra);
    }

    public List<Palavra> buscaPorPalavra(String nome){

        return palavraRepository.findByPalavra(nome);
    }


}
