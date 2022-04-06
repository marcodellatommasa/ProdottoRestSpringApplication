package it.devlecce.ProdottoRestSpring.avviso;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdottoRestController {

        private final ProdottoRepository repository;
        ProdottoRestController(ProdottoRepository repository) {
            this.repository = repository;
        }
        @GetMapping("/prodotti")
        List<Prodotto> tutti() {
            return repository.findAll();
        }
        @PostMapping("/prodotto")
        Prodotto nuovoProdotto(@RequestBody Prodotto nuovoProdotto) {
            return repository.save(nuovoProdotto);
        }
    @GetMapping("/prodotti/{id}")
    Prodotto singoloProdotto(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProdottoNonTrovato(id));
    }
    @PutMapping("/prodotti/{id}")
    Prodotto aggiornaProdotto(@RequestBody Prodotto prodotto, @PathVariable Long id) {
        return repository.save(prodotto);}
    @DeleteMapping("/prodotto/{id}")
    void eliminaProdotto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

