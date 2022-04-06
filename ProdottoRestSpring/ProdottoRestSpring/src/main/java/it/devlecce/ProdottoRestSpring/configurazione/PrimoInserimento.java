package it.devlecce.ProdottoRestSpring.configurazione;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PrimoInserimento {


        private static final Logger log = LoggerFactory.getLogger(PrimoInserimento.class);
        @Bean
        CommandLineRunner initDatabase(ProdottoRepository repository) {
            return args -> {
                Prodotto p1 = new Prodotto("Lavatrice", 100);
                Prodotto p2 = new Prodotto("Fiori", 200);
                Prodotto p3 = new Prodotto("Scala", 500);

                List<Prodotto> prodotti = new ArrayList<>();
                repository.saveAll(prodotti);
            };
        }
    }

