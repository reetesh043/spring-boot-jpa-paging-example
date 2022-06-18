package com.reet.spring.data.jpa.paging.service;

import com.reet.spring.data.jpa.paging.model.Country;
import com.reet.spring.data.jpa.paging.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
  @Autowired private CountryRepository repository;

  @Override
  public Page<Country> findPaginated(int pageNo, int pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize);

    return repository.findAll(paging);
  }
}
