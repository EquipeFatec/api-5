package SanjaValley.Persuance.Service;

import SanjaValley.Persuance.Entity.Palavra;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
public class PalavraServiceImpTest {

    @Autowired
    private PalavraService service;

    @Test
    public void instaciarPalavraTest(){//quando a palavra for vazia retorna a lista vazia
        List<Palavra> palavraList = service.buscaPorPalavra(null);
        assertTrue(palavraList.isEmpty());

    }

}
