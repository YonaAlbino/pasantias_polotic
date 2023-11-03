/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.model.Modelo_pasante;
import com.polotic.pasantias.service.IModeloPasanteService;
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
@RequestMapping("/modeloPasante")
public class ModeloPasanteController {
    
    @Autowired
    private IModeloPasanteService pasanteService;
    
    @GetMapping("/buscar")
    public ResponseEntity<Modelo_pasante> findModeloPasante(@RequestParam Long id){
        Modelo_pasante modelo_pasante = pasanteService.findModeloPasante(id);
        return new ResponseEntity<>(modelo_pasante, HttpStatus.FOUND);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<String> saveModeloPasante(@RequestBody Modelo_pasante modelo_pasante){
        pasanteService.saveModeloPasante(modelo_pasante);
        return new ResponseEntity<>("Modelo de pasante creado exitosamente", HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar")
    public ResponseEntity<String> deleteModeloPasante(@RequestParam Long id){
        pasanteService.deleteModeloPasante(id);
        return new ResponseEntity<>("Modelo pasante eliminado exitosamente", HttpStatus.OK);
    }
    
    @GetMapping("/traer/todos")
    public ResponseEntity<List<Modelo_pasante>> getModeloPasantes(){
        List<Modelo_pasante> listaModeloPasantes = pasanteService.getModeloPasantes();
        return new ResponseEntity<>(listaModeloPasantes, HttpStatus.FOUND);
    }
    
    @PutMapping("/modificar")
    public ResponseEntity<String> editModeloPasante(@RequestBody Modelo_pasante modelo_pasante){
        pasanteService.editModeloPasante(modelo_pasante);
        return new ResponseEntity<>("Modelo de pasante modificado con exito", HttpStatus.OK);
    }
    
}
