package com.api.population.controller;

import com.api.population.dto.DtoResp;
import com.api.population.model.EducPopulation;
import com.api.population.service.EducPopulationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/")
    public ResponseEntity<DtoResp> add(@RequestBody EducPopulation educPopulation){
        return new ResponseEntity<>(educPopulationService.add(educPopulation), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<DtoResp> update(@RequestBody EducPopulation educPopulation){
        return new ResponseEntity<>(educPopulationService.update(educPopulation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DtoResp> delete(@PathVariable Long id){
        return new ResponseEntity<>(educPopulationService.deleteElem(id), HttpStatus.OK);
    }
}
