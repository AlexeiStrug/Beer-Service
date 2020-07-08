package com.example.beerservice.service;

import com.example.beerservice.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beer);

    BeerDto updateBeer(UUID beerId, BeerDto beer);
}
