package SanjaValley.Persuance.Controller;


import SanjaValley.Persuance.Entity.Palavra;
import SanjaValley.Persuance.Repository.PalavraRepository;
import SanjaValley.Persuance.Service.PalavraServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/teste")
public class PalavraController {

    @Autowired
    private PalavraServiceImp palavraService;

    @GetMapping(value = "/{palavra}")
    public ResponseEntity<List<Palavra>> findByPalavra(@PathVariable String palavra){
        try {
            List<Palavra> list = palavraService.buscaPorPalavra(palavra);
            if(list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<Palavra> createTutorial(@RequestBody Palavra palavra) {
        try {
            Palavra _tutorial = palavraService.novaPalavra(palavra);
                    //.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}