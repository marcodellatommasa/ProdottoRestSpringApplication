package it.devlecce.ProdottoRestSpring.avviso;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class ProdottoRestController {
    private static Logger logger = LoggerFactory.getLogger(ProdottoRestController.class);
    private ProdottoRepository repository;

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
    public Prodotto aggiornaDatiProdotto( @PathVariable Long id, @RequestBody Prodotto prodotto) {
        return repository.findById(id)
                .map(
                        nuovoProdotto -> {
                            nuovoProdotto.setNome(prodotto.getNome());
                            nuovoProdotto.setPrezzo(prodotto.getPrezzo());
                            nuovoProdotto.setDatadiacquisto(prodotto.getDatadiacquisto());
                            return repository.save(nuovoProdotto);
                        })
                .orElseGet(() -> {
                    //il prodotto esiste
                    prodotto.setId(id);
                    return repository.save(prodotto);
                }
                );
    }

    @DeleteMapping("/prodotto/{id}")
    void eliminaProdotto(@PathVariable Long id) {
        repository.deleteById(id);

    }

    //cerca prodotto per nome
    @GetMapping("/prodotti/ricerca/nome/{nome}")
    List<Prodotto> cercaPerNome(@PathVariable String nome) {
        return repository.findByNome(nome);
    }

    //cerca prodotto per data
    @RequestMapping(path = "/prodotti/ricerca/datadiacquisto",
    method = RequestMethod.GET)
    public List<Prodotto> trovaProdottoPerDataDiAcquisto(
            @RequestParam(name = "datada")
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date from,
            @RequestParam(name = "dataa")
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date to){
        return repository.findByDatadiacquistoBetween(from, to);

    }
    // Caricamento di file
    @PostMapping("/caricafile")
    public String caricaFile (@RequestParam("file") MultipartFile file){
        String infoFile = file.getOriginalFilename() + " - "+ file.getContentType();
        String conFormat = String.format("%s-%s", file.getOriginalFilename(), file.getContentType());
        logger.info(infoFile);
        logger.warn(conFormat);
        return conFormat;
    }


}

