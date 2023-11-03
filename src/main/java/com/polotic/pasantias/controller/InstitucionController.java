/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;


import com.polotic.pasantias.model.Institucion;
import com.polotic.pasantias.service.IIinstitucionService;
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
@RequestMapping("/institucion")
public class InstitucionController {

    @Autowired
    private IIinstitucionService institucionService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveInstitucion(@RequestBody Institucion institucion) {
        institucionService.saveInstitucion(institucion);
        return new ResponseEntity<>("Institución creada exitosamente", HttpStatus.CREATED);
    }
    
    @GetMapping("/traer/todas")
    public ResponseEntity<List<Institucion>> getInstituciones(){
        List<Institucion> listaInstituciones = institucionService.getInstituciones();
        return new ResponseEntity<>(listaInstituciones, HttpStatus.FOUND);
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<Institucion> findInstitucion(@RequestParam Long id){
        Institucion institucion = institucionService.findInstitucion(id);
        return new ResponseEntity<>(institucion, HttpStatus.FOUND);
    }
    
    @PutMapping("/modificar")
    public ResponseEntity<String> editInstitucion(@RequestBody Institucion institucion){
        institucionService.editInstitucion(institucion);
        return new ResponseEntity<>("Institución modificada exitosamente", HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> deleteInstitucion(@RequestParam Long id){
        institucionService.deleteInsitucion(id);
        return new ResponseEntity<>("Institución eliminada correctamente", HttpStatus.OK);
    }
}
