/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.model.Localidad;
import com.polotic.pasantias.service.ILocalidadService;
import com.polotic.pasantias.service.LocalidadService;
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
@RequestMapping("/localidad")
public class LocalidadController {

    @Autowired
    private ILocalidadService localdiadService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveLocalidad(@RequestBody Localidad localidad) {
        localdiadService.saveLocalidad(localidad);
        return new ResponseEntity<>("Localidad creada exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/traer/todas")
    public ResponseEntity<List<Localidad>> getLocalidades() {
        List<Localidad> listaLocalidades = localdiadService.getLocalidades();
        return new ResponseEntity<>(listaLocalidades, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar")
    public void deleteLocalidad(@RequestParam Long id) {
        localdiadService.deleteLocalidad(id);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Localidad> findLocalidad(@RequestParam Long id){
        Localidad localidad = localdiadService.findLocalidad(id);
        return new ResponseEntity<>(localidad, HttpStatus.OK);
    }
    
    @PutMapping("/modificar")
    public void editLocalidad(@RequestBody Localidad localidad){
        localdiadService.editLocalidad(localidad);
    }
    

    
}
