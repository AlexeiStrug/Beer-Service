package com.example.beerservice.utils.mappers;

import com.example.beerservice.model.BeerDto;
import com.example.beerservice.model.BeerEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(BeerEntity beer);

    BeerEntity beerDtoToBeer(BeerDto beerDto);
}
