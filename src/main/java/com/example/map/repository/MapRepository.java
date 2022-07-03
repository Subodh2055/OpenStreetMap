package com.example.map.repository;

import com.example.map.entity.MapView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<MapView, Long> {

}
