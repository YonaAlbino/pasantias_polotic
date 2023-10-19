/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.model.Institucion;
import com.polotic.pasantias.model.Nivel;
import com.polotic.pasantias.service.INivelService;
import com.polotic.pasantias.service.NivelService;
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
@RequestMapping("/nivel")
public class NivelController {

    @Autowired
    private INivelService nivelSerivice;

    @PostMapping("/crear")
    public ResponseEntity<Nivel> saveNivel(@RequestBody Nivel nivel) {
        nivelSerivice.saveNivel(nivel);
        return new ResponseEntity<>(nivel, HttpStatus.CREATED);
    }

    @GetMapping("/traer/todos")
    public ResponseEntity<List<Nivel>> getNiveles() {
        List<Nivel> listaNiveles = nivelSerivice.getNiveles();
        return new ResponseEntity<>(listaNiveles, HttpStatus.FOUND);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Nivel> findNivel(@RequestParam Long id) {
        Nivel nivel = nivelSerivice.findNivel(id);
        return new ResponseEntity<>(nivel, HttpStatus.FOUND);
    }

    @DeleteMapping("/eliminar")
    public void deleteNivel(@RequestParam Long id) {
        nivelSerivice.deleteNivel(id);
    }

    @PutMapping("/modificar")
    public void editNivel(@RequestBody Nivel nivel) {
        this.saveNivel(nivel);
    }
}
