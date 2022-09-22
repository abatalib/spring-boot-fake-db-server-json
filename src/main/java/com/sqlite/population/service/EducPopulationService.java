package com.sqlite.population.service;

import com.sqlite.population.dto.DtoResp;

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
}
