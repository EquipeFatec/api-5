package SanjaValley.Persuance.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SanjaValley.Persuance.Repository.PalavraRepository;
import SanjaValley.Persuance.entity.Palavra;

@Service

public class PalavraServiceImp implements PalavraService{

    @Autowired
    private PalavraRepository palavraRepository;


    @Override
    public Palavra novaPalavra(Palavra palavra) {

        return palavraRepository.save(palavra);
    }

    public List<Palavra> buscaPorPalavra(String palavra){

        return palavraRepository.findByPalavra(palavra);
    }


/*
    public List<Palavra> buscarPorPalavraNoTexto(String palavra){
        String[] arrOfStr = palavra.split(" ");

        for (String a : arrOfStr)
            palavraRepository.findByPalavra(a);

        return  null;
    }*/


}
