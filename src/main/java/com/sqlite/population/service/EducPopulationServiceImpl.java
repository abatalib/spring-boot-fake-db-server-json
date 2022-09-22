package com.sqlite.population.service;

import com.sqlite.population.dto.DtoResp;
import com.sqlite.population.model.EducPopulation;
import com.sqlite.population.repository.EducPopulationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EducPopulationServiceImpl implements EducPopulationService {
    private EducPopulationRepository educPopulationRepository;

    @Override
    public DtoResp getList() {
        List<EducPopulation> result = educPopulationRepository.findAll();
        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
                );

        return dtoResp;
    }

    @Override
    public DtoResp getListPerAge(int age) {
        List<EducPopulation> result = educPopulationRepository.findByAge(age);
        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
        );
        return dtoResp;
    }

    @Override
    public DtoResp getListPerUpAge(int age) {
        List<EducPopulation> result = educPopulationRepository.findByAgeGreaterThanEqual(age);
        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
        );
        return dtoResp;
    }

    @Override
    public DtoResp getListPerLessAge(int age) {
        List<EducPopulation> result = educPopulationRepository.findByAgeIsLessThanEqual(age);
        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
        );
        return dtoResp;
    }

    @Override
    public DtoResp getListPerCName(String cName) {
        List<EducPopulation> result = educPopulationRepository.findByCountryName(cName.toUpperCase());
        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
        );
        return dtoResp;
    }

    @Override
    public DtoResp getListPerCCode(String cCode) {
        List<EducPopulation> result = educPopulationRepository.findByCountryCode(cCode.toUpperCase());
        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
        );
        return dtoResp;
    }

    @Override
    public DtoResp getListPerAgeCountry(int age, String cName) {
        List<EducPopulation> result = new ArrayList<>();
        EducPopulation educ = educPopulationRepository.findByAgeCountry(age, cName.toUpperCase());

        if (educ != null) result.add(educ);

        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
        );
        return dtoResp;
    }

    @Override
    public DtoResp getListPerUpAgeCountry(int age, String cName) {
        List<EducPopulation> result = educPopulationRepository.findByUpAgeCountry(age, cName.toUpperCase());

        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
        );
        return dtoResp;
    }

    @Override
    public DtoResp getListPerLessAgeCountry(int age, String cName) {
        List<EducPopulation> result = educPopulationRepository.findByLessAgeCountry(age, cName.toUpperCase());

        DtoResp dtoResp = new DtoResp(
                result.size(),
                result
        );
        return dtoResp;
    }
}
