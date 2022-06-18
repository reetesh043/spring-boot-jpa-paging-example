package com.reet.spring.data.jpa.paging.controller;

import com.reet.spring.data.jpa.paging.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CountryController {

  @Autowired private CountryService countryService;

  @GetMapping("/countries/{pageNo}/{pageSize}")
  public ResponseEntity<Map<String, Object>> getPaginatedCountries(
      @PathVariable int pageNo, @PathVariable int pageSize) {
    try {
      var countries = countryService.findPaginated(pageNo, pageSize);
      var countryList = countries.getContent();
      if (countryList.size() == 0) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      Map<String, Object> response = new HashMap<>();
      response.put("countries", countryList);
      response.put("currentPage", countries.getNumber());
      response.put("totalItems", countries.getTotalElements());
      response.put("totalPages", countries.getTotalPages());
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
