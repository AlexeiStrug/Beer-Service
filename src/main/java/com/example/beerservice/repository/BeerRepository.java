package com.example.beerservice.repository;

import com.example.beerservice.model.BeerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeerRepository extends PagingAndSortingRepository<BeerEntity, UUID> {
}
