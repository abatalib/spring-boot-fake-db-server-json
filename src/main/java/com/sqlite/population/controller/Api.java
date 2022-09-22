package com.sqlite.population.controller;

import com.sqlite.population.dto.DtoResp;
import com.sqlite.population.service.EducPopulationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@Transactional
public class Api {
    private EducPopulationService educPopulationService;

    @GetMapping("/")
    public ResponseEntity<DtoResp> getList(){
        return new ResponseEntity<>(educPopulationService.getList(), HttpStatus.OK);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<DtoResp> getListByAge(@PathVariable int age){
        return new ResponseEntity<>(educPopulationService.getListPerAge(age), HttpStatus.OK);
    }

    @GetMapping("/age/up/{age}")
    public ResponseEntity<DtoResp> getListByUpAge(@PathVariable int age){
        return new ResponseEntity<>(educPopulationService.getListPerUpAge(age), HttpStatus.OK);
    }

    @GetMapping("/age/less/{age}")
    public ResponseEntity<DtoResp> getListByLessAge(@PathVariable int age){
        return new ResponseEntity<>(educPopulationService.getListPerLessAge(age), HttpStatus.OK);
    }

    @GetMapping("/age/up/{age}/country-name/{cname}")
    public ResponseEntity<DtoResp> getListByUpAgeCountry(@PathVariable("age") int age,
                                                  @PathVariable("cname") String cName){
        return new ResponseEntity<>(educPopulationService.getListPerUpAgeCountry(age,cName), HttpStatus.OK);
    }

    @GetMapping("/age/less/{age}/country-name/{cname}")
    public ResponseEntity<DtoResp> getListByLessAgeCountry(@PathVariable("age") int age,
                                                           @PathVariable("cname") String cName){
        return new ResponseEntity<>(educPopulationService.getListPerLessAgeCountry(age, cName), HttpStatus.OK);
    }

    @GetMapping("/country-name/{cname}")
    public ResponseEntity<DtoResp> getListByCountryName(@PathVariable("cname") String cName){
        return new ResponseEntity<>(educPopulationService.getListPerCName(cName), HttpStatus.OK);
    }

    @GetMapping("/country-code/{ccode}")
    public ResponseEntity<DtoResp> getListByCountryCode(@PathVariable("ccode") String cCode){
        return new ResponseEntity<>(educPopulationService.getListPerCCode(cCode), HttpStatus.OK);
    }

    @GetMapping("/age/{age}/country-name/{cname}")
    public ResponseEntity<DtoResp> getListByAgeCountryName(@PathVariable("age") int age,
                                                           @PathVariable("cname") String cName){
        return new ResponseEntity<>(educPopulationService.getListPerAgeCountry(age, cName), HttpStatus.OK);
    }
}
