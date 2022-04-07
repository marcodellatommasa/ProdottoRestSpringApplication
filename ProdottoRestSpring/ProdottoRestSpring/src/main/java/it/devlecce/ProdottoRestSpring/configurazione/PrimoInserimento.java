package it.devlecce.ProdottoRestSpring.configurazione;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PrimoInserimento {


        private static final Logger logger = LoggerFactory.getLogger(PrimoInserimento.class);
        @Bean
        CommandLineRunner initDatabase(ProdottoRepository repository) {
            return args -> {
                logger.info("Primo Inserimento");
                SimpleDateFormat dataAcquisto = new SimpleDateFormat("dd-MM-yyyy");
                Date datadiacquisto1 = dataAcquisto.parse("10-06-2019");
                Date datadiacquisto2 = dataAcquisto.parse("08-02-2020");
                Date datadiacquisto3 = dataAcquisto.parse("29-04-2022");

                Prodotto p1 = new Prodotto("Pallone da calcio", 50f, datadiacquisto1);
                Prodotto p2 = new Prodotto("Racchetta da tennis", 40f, datadiacquisto2);
                Prodotto p3 = new Prodotto("Set da ping pong", 120f, datadiacquisto3);

                List<Prodotto> prodotti = new ArrayList<>();
                prodotti.add(p1);
                prodotti.add(p2);
                prodotti.add(p3);
                repository.saveAll(prodotti);
            };
        }
    }

