/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.model.Reunion;
import com.polotic.pasantias.service.IReunionService;
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
@RequestMapping("/reunion")
public class ReunionController {
    
    @Autowired
    private IReunionService reunionService;
    
    @GetMapping("/traer/todas")
    public ResponseEntity<List<Reunion>> gerReuniones(){
        List<Reunion> lista = reunionService.getReuniones();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<String> saveReunion(@RequestBody Reunion reunion){
        reunionService.saveReunion(reunion);
        return new ResponseEntity<>("La reunion se creo con exito", HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar")
    public ResponseEntity<String> deleteReunion(@RequestParam Long id){
        reunionService.deleteReunion(id);
        return new ResponseEntity<>("La reunion se elimino con exito", HttpStatus.OK);
    }
    
    @PutMapping("/modificar")
    public ResponseEntity<String> editReunion(@RequestBody Reunion reunion){
        reunionService.editReunion(reunion);
        return new ResponseEntity<>("Reunion modificada", HttpStatus.OK);
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<Reunion> findReunion(@RequestParam Long id){
        Reunion reunion = reunionService.findReunion(id);
        return new ResponseEntity<>(reunion, HttpStatus.FOUND);
    }
    
}
