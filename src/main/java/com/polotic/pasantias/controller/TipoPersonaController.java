/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.model.Tipo_persona;
import com.polotic.pasantias.service.ITipoPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoPersona")
public class TipoPersonaController {

    @Autowired
    private ITipoPersonaService tipoService;

    @GetMapping("/traer/todas")
    public ResponseEntity<List<Tipo_persona>> getTipoPersonas() {
        List<Tipo_persona> listaTipos = tipoService.getTiposPersona();
        return new ResponseEntity<>(listaTipos, HttpStatus.FOUND);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Tipo_persona> getTipoPersona(@RequestParam Long id){
        Tipo_persona tipoPersona = tipoService.findTipoPersona(id);
        return new ResponseEntity<>(tipoPersona, HttpStatus.FOUND);
    }
    
    @DeleteMapping("/borrar")
    public ResponseEntity<String> deleteTipoPersona(@RequestParam Long id){
        tipoService.deleteTipoPersona(id);
        return new ResponseEntity<>("El tipo de persona se ha eliminado con exito", HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Tipo_persona> saveTipoPersona(@RequestBody Tipo_persona tipo_persona){
        tipoService.saveTipoPersona(tipo_persona);
        return new ResponseEntity<>(tipo_persona, HttpStatus.OK);
    }

}
