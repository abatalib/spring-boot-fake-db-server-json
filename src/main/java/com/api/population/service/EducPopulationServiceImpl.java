package com.api.population.service;

import com.api.population.dto.DtoResp;
import com.api.population.model.EducPopulation;
import com.api.population.repository.EducPopulationRepository;
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
        try {
            List<EducPopulation> result = educPopulationRepository.findAll();
            String msg = !result.isEmpty() ? "Toute la liste" : "Aucune donnée!";
            return sendResp(result,msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp getListPerAge(int age) {
        try{
            List<EducPopulation> result = educPopulationRepository.findByAge(age);
            String msg = !result.isEmpty() ? "Liste Age = "+age : "Aucune donnée!";
            return sendResp(result,msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp getListPerUpAge(int age) {
        try{
            List<EducPopulation> result = educPopulationRepository.findByAgeGreaterThanEqual(age);
            String msg = !result.isEmpty() ? "Liste Age >= "+age : "Aucune donnée!";
            return sendResp(result,msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp getListPerLessAge(int age) {
        try{
            List<EducPopulation> result = educPopulationRepository.findByAgeIsLessThanEqual(age);
            String msg = !result.isEmpty() ? "Liste Age <= "+age : "Aucune donnée!";
            return sendResp(result, msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp getListPerCName(String cName) {
        try{
            List<EducPopulation> result = educPopulationRepository.findByCountryName(cName.toUpperCase());
            String msg = !result.isEmpty() ? "Liste country_name = "+cName : "Aucune donnée!";
            return sendResp(result,msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp getListPerCCode(String cCode) {
        try{
            List<EducPopulation> result = educPopulationRepository.findByCountryCode(cCode.toUpperCase());
            String msg = !result.isEmpty() ? "Liste country_code = "+cCode : "Aucune donnée!";
            return sendResp(result, msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp getListPerAgeCountry(int age, String cName) {
        try{
            List<EducPopulation> result = new ArrayList<>();
            EducPopulation educ = educPopulationRepository.findByAgeCountry(age, cName.toUpperCase());

            if (educ != null) result.add(educ);

            String msg = !result.isEmpty() ? "Liste Age = "+age+" et country_name = "+cName : "Aucune donnée!";

            return sendResp(result, msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp getListPerUpAgeCountry(int age, String cName) {
        try{
            List<EducPopulation> result = educPopulationRepository.findByUpAgeCountry(age, cName.toUpperCase());
            String msg = !result.isEmpty() ? "Liste Age >= "+age+" et country_name = "+cName : "Aucune donnée!";

            return sendResp(result, msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp getListPerLessAgeCountry(int age, String cName) {
        try{
            List<EducPopulation> result = educPopulationRepository.findByLessAgeCountry(age, cName.toUpperCase());
            String msg = !result.isEmpty() ? "Liste Age <= "+age+" et country_name = "+cName : "Aucune donnée!";

            return sendResp(result,msg);
        }catch(RuntimeException ex){
            return new DtoResp(
                "failure",
                ex.getMessage(),
                0,
                null
            );
        }
    }

    @Override
    public DtoResp add(EducPopulation educPopulation) {
        try{
            List<EducPopulation> educPopulationList = new ArrayList<>();
            //test si les chps obligatoires sont passés
            if(educPopulation.getCountry_name() == null || educPopulation.getCountry_name().isEmpty() ||
                    educPopulation.getCountry_code() == null || educPopulation.getCountry_code().isEmpty() ||
                    educPopulation.getAge() <= 0) {
                return new DtoResp(
                        "failure",
                        "Les champs suivants sont obligatoires : country_name, country_code, age>0",
                        0,
                        null
                );
            }
            //dernier id
            Long lastId = educPopulationRepository.findLastId();
            if(lastId<=0)
                return new DtoResp(
                        "failure",
                        "Problème d'Id",
                        0,
                        null
                );
            lastId+=1;
            educPopulation.setId(lastId);


            //test doublant
            Optional<EducPopulation> educPopulationOptional = educPopulationRepository.
                    searchDoublant(educPopulation.getCountry_name().toUpperCase(),
                            educPopulation.getCountry_code().toUpperCase(),
                            educPopulation.getAge());

            if(educPopulationOptional.isPresent())
                return new DtoResp(
                        "failure",
                        "Valeur(s) de(s) champ(s) exist(ent) déjà country_name, country_code pour le même âge!",
                        0,
                        null
                );

            educPopulationList.add(educPopulationRepository.save(educPopulation));
            if(!educPopulationList.isEmpty())
                return new DtoResp(
                            "success",
                            "Opération effectuée",
                            1,
                            educPopulationList
                    );
            else
                return new DtoResp(
                            "failure",
                            "Problème lors de l'enregistrement",
                            0,
                            null
                    );
        }catch(RuntimeException ex){
            return new DtoResp(
                    "failure",
                    ex.getMessage(),
                    0,
                    null
            );
        }
    }

    @Override
    public DtoResp update(EducPopulation educPopulation) {
        try{
            List<EducPopulation> educPopulationList = new ArrayList<>();
            //test si les chps obligatoires sont passés
            if(educPopulation.getId() == null || educPopulation.getId() <= 0 ||
                educPopulation.getCountry_name() == null || educPopulation.getCountry_name().isEmpty() ||
                educPopulation.getCountry_code() == null || educPopulation.getCountry_code().isEmpty() ||
                educPopulation.getAge() <= 0) {
                return new DtoResp(
                        "failure",
                        "Les champs suivants sont obligatoires : id de la ligne concernée, country_name, country_code, age>0",
                        0,
                        null
                );
            }

            //test si l'enregistrement existe déjà
            if(!educPopulationRepository.existsById(educPopulation.getId())){
                return new DtoResp(
                        "failure",
                        "L'Id passé n'existe pas",
                        0,
                        null);
            }

            educPopulationList.add(educPopulationRepository.save(educPopulation));
            if(!educPopulationList.isEmpty())
                return new DtoResp(
                        "success",
                        "Opération effectuée",
                        1,
                        educPopulationList
                );
            else
                return new DtoResp(
                        "failure",
                        "Problème lors de l'enregistrement",
                        0,
                        null
                );
        }catch(RuntimeException ex){
            return new DtoResp(
                    "failure",
                    ex.getMessage(),
                    0,
                    null
            );
        }
    }

    @Override
    public DtoResp deleteElem(Long id) {
        try{
            //test si l'id est passé
            if(id == null || id <= 0) {
                return new DtoResp(
                        "failure",
                        "L'id de l'enregistrement à supprimer est obligatoire!",
                        0,
                        null
                );
            }

            //test si l'id existe déjà
            if(!educPopulationRepository.existsById(id)){
                return new DtoResp(
                        "failure",
                        "L'Id passé n'existe pas",
                        0,
                        null);
            }

            if(educPopulationRepository.deleteElem(id)==1)
                return new DtoResp(
                        "success",
                        "Opération effectuée",
                        1,
                        null
                );
            else
                return new DtoResp(
                        "failure",
                        "Problème lors de l'enregistrement",
                        0,
                        null
                );
        }catch(RuntimeException ex){
            return new DtoResp(
                    "failure",
                    ex.getMessage(),
                    0,
                    null
            );
        }
    }

    private DtoResp sendResp(List result, String msg){
        return new DtoResp(
            "success",
            msg,
            result.size(),
            result
        );
    }
}
