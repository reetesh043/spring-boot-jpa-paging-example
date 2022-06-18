package com.reet.spring.data.jpa.paging.repository;

import com.reet.spring.data.jpa.paging.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {}
