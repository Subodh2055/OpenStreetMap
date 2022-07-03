package com.example.map.service;

import com.example.map.entity.MapView;
import com.example.map.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class MapService {

    private final MapRepository mapRepository;

    @Autowired
    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public MapView save(MapView mapView) {
        return mapRepository.save(mapView);
    }

    public List<MapView> findAllLatlngs() {
        return mapRepository.findAll();
    }

    public MapView findById(Long id) {
        return mapRepository.findById(id).get();
    }
}
