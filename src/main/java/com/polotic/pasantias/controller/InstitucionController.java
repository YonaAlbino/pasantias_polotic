/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.model.Contacto;
import com.polotic.pasantias.model.Institucion;
import com.polotic.pasantias.model.Localidad;
import com.polotic.pasantias.model.Nivel;
import com.polotic.pasantias.service.InstitucionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institucion")
public class InstitucionController {
    
    @Autowired
    private InstitucionService intitucionService;
    
    @PostMapping("/crear")
    public ResponseEntity<String> saveInstitucion(@RequestBody Institucion institucion) {
        
        intitucionService.saveInstitucion(institucion);
        return new ResponseEntity<>("Institución creada exitosamente", HttpStatus.CREATED);
    }
}
