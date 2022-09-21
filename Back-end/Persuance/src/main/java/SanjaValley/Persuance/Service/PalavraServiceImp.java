package SanjaValley.Persuance.Service;

import java.lang.reflect.Method;
import java.util.List;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SanjaValley.Persuance.Entity.Palavra;
import SanjaValley.Persuance.Repository.PalavraRepository;

@Service
public class PalavraServiceImp implements PalavraService{

    @Autowired
    private PalavraRepository palavraRepository;


    @Override
    public Palavra novaPalavra(Palavra palavra) {

      List<Palavra> palavraList = palavraRepository.findByPalavraAndClasseGramaticalOrderByRevisaoDesc(palavra.getPalavra(),palavra.getClasseGramatical());
      if(!palavraList.isEmpty()){
          palavra.setRevisao(palavraList.get(0).getRevisao() +1);
      }else{
          palavra.setRevisao(1);
        }
       return palavraRepository.save(palavra);
    }

    @Override
    public List<Palavra> buscaPorPalavra(String palavra){
        //todo if usuario admin uma busca
        List<Palavra> teste = palavraRepository.findByPalavraOrderByRevisaoDesc(palavra);
        if(teste.isEmpty()){
            return teste;
        }
        return palavraRepository.findByPalavraOrderByRevisaoDesc(palavra);
    }


/*
    public List<Palavra> buscarPorPalavraNoTexto(String palavra){
        String[] arrOfStr = palavra.split(" ");

        for (String a : arrOfStr)
            palavraRepository.findByPalavra(a);

        return  null;
    }*/


}
