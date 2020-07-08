package com.example.beerservice.bootstrap;

import com.example.beerservice.model.BeerEntity;
import com.example.beerservice.model.BeerStyleEnum;
import com.example.beerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

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
            BeerEntity b1 = BeerEntity.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyleEnum.IPA.name())
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.95"))
                    .upc(BEER_1_UPC)
                    .build();

            BeerEntity b2 = BeerEntity.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleEnum.PALE_ALE.name())
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.95"))
                    .upc(BEER_2_UPC)
                    .build();

            BeerEntity b3 = BeerEntity.builder()
                    .beerName("Pinball Porter")
                    .beerStyle(BeerStyleEnum.PALE_ALE.name())
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.95"))
                    .upc(BEER_3_UPC)
                    .build();

            beerRepository.save(b1);
            beerRepository.save(b2);
            beerRepository.save(b3);
        }

    }
}
