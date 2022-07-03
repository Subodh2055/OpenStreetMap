package com.example.map.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class MapViewDto {

    private Long id;

    private List<Map<String, Double>> latLng;

    private Double area;

}
