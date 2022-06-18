package com.reet.spring.data.jpa.paging.service;

import com.reet.spring.data.jpa.paging.model.Country;
import org.springframework.data.domain.Page;

public interface CountryService {

  Page<Country> findPaginated(int pageNo, int pageSize);
}
