/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.model.Area;
import com.polotic.pasantias.model.Persona;
import com.polotic.pasantias.service.AreaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveArea(@RequestBody Area area) {
        areaService.saveArea(area);
        return new ResponseEntity<>("Area creada exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/traer/todas")
    private ResponseEntity<List<Area>> getAreas() {
        List<Area> listaArea = areaService.getAreas();

        if (!listaArea.isEmpty()) {
            return new ResponseEntity<>(listaArea, HttpStatus.FOUND);
        } else {
            throw new ListaVaciaException("La lista de areas se encuentra vacia");
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> deleteArea(@RequestParam Long id) {
        areaService.deleteArea(id);
        return new ResponseEntity<>("Persona eliminada", HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> editArea(@RequestBody Area area) {
        areaService.editArea(area);
        return new ResponseEntity<>("Area modificada exitosamente", HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Area> findArea(@RequestParam Long id) {
        Area area = areaService.findArea(id);
        return new ResponseEntity<>(area, HttpStatus.OK);
    }
}
