package com.example.map.controller;

import com.example.map.dto.MapViewDto;
import com.example.map.entity.MapView;
import com.example.map.repository.MapRepository;
import com.example.map.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class MapController {
    private final MapService mapService;

    @GetMapping("/map")
    public String helloMap() {
        return "map.html";
    }

    @PostMapping("/save")
    public ResponseEntity<MapView> save(@RequestBody MapViewDto mapViewDto, ModelAndView modelAndView) {
        MapView mapView = MapView.builder()
                .area(mapViewDto.getArea())
                .latLng(mapViewDto.getLatLng().toString())
                .build();
        MapView newMapview = mapService.save(mapView);
        return new ResponseEntity<>(newMapview, HttpStatus.CREATED);
    }

    @RequestMapping("/all")
    public ResponseEntity<List<MapView>> getAllLatlng() {
        List<MapView> latlngs = mapService.findAllLatlngs();
        return new ResponseEntity<>(latlngs, HttpStatus.OK);
    }

    @GetMapping("/view")
    public ModelAndView getAlllatlng(Model model) {
        ModelAndView modelAndView = new ModelAndView("listlatlng");
        modelAndView.addObject("mapValue", mapService.findAllLatlngs());
        return modelAndView;
    }

    @GetMapping("/displayMap/{id}")
    public ModelAndView displayMap(@PathVariable Long id) {
        MapView mapView = mapService.findById(id);
        ModelAndView modelAndView = new ModelAndView("map");
        modelAndView.addObject("mapValue", mapView);
        return modelAndView;
    }

}
