package com.api.population.repository;

import com.api.population.model.EducPopulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducPopulationRepository extends JpaRepository<EducPopulation,Long> {
    List<EducPopulation> findByAge(int age);
    List<EducPopulation> findByAgeGreaterThanEqual(int age);
    List<EducPopulation> findByAgeIsLessThanEqual(int age);

    @Query("SELECT e FROM EducPopulation e WHERE UPPER(e.country_name)=UPPER(?1)")
    List<EducPopulation> findByCountryName(String cName);

    @Query("SELECT e FROM EducPopulation e WHERE UPPER(e.country_code)=UPPER(?1)")
    List<EducPopulation> findByCountryCode(String cCode);

    @Query("SELECT e FROM EducPopulation e WHERE e.age=?1 AND UPPER(e.country_name)=UPPER(?2)")
    EducPopulation findByAgeCountry(int age, String cName);

    @Query("SELECT e FROM EducPopulation e WHERE e.age>=?1 AND UPPER(e.country_name)=UPPER(?2)")
    List<EducPopulation> findByUpAgeCountry(int age, String cName);

    @Query("SELECT e FROM EducPopulation e WHERE e.age<=?1 AND UPPER(e.country_name)=UPPER(?2)")
    List<EducPopulation> findByLessAgeCountry(int age, String cName);

    @Query("SELECT MAX (e.id) as last FROM EducPopulation e")
    Long findLastId();

    @Query("SELECT e FROM EducPopulation e WHERE UPPER(e.country_name)=?1 AND UPPER(e.country_code)=?2 AND e.age=?3")
    Optional<EducPopulation> searchDoublant(String cName, String cCode, int age);

    @Query("DELETE FROM EducPopulation WHERE id=?1")
    @Modifying
    Integer deleteElem(Long id);
}
