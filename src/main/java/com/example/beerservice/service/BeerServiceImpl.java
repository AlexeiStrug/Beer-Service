package com.example.beerservice.service;

import com.example.beerservice.model.BeerEntity;
import com.example.beerservice.utils.exceptions.NotFoundException;
import com.example.beerservice.utils.mappers.BeerMapper;
import com.example.beerservice.model.BeerDto;
import com.example.beerservice.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("beerService")
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beer) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beer)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beer) {
        BeerEntity found = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        found.setBeerName(beer.getBeerName());
        found.setBeerStyle(beer.getBeerStyle().name());
        found.setPrice(beer.getPrice());
        found.setUpc(beer.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(found));
    }
}
