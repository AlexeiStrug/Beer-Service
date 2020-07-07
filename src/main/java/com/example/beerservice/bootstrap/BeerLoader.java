package com.example.beerservice.bootstrap;

import com.example.beerservice.model.BeerEntity;
import com.example.beerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if (beerRepository.count() == 0) {
            beerRepository.save(BeerEntity.builder()
                    .beerName("Mango APE")
                    .beerStyle("APE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(23123123L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(BeerEntity.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(23123133L)
                    .price(new BigDecimal("11.95"))
                    .build());
        }

    }
}
