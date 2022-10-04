package com.api.population.service;

import com.api.population.dto.DtoResp;
import com.api.population.model.EducPopulation;

public interface EducPopulationService {
    DtoResp getList();

    DtoResp getListPerAge(int age);
    DtoResp getListPerUpAge(int age);
    DtoResp getListPerLessAge(int age);

    DtoResp getListPerCName(String cName);
    DtoResp getListPerCCode(String cCode);

    DtoResp getListPerAgeCountry(int age, String cName);
    DtoResp getListPerUpAgeCountry(int age, String cName);
    DtoResp getListPerLessAgeCountry(int age, String cName);

    DtoResp add(EducPopulation educPopulation);
    DtoResp update(EducPopulation educPopulation);
    DtoResp deleteElem(Long id);
}
