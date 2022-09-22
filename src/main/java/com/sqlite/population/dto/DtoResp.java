package com.sqlite.population.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class DtoResp <T extends Serializable>{
    private int totalElem;
    private List<T> entity = new ArrayList<>();
}
