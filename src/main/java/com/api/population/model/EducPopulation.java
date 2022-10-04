package com.api.population.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class EducPopulation {
    @Id
    private Long id;

    private String country_code;
    private String country_name;
    private int age;
    private Long y2000;
    private Long y2001;
    private Long y2002;
    private Long y2003;
    private Long y2004;
}
