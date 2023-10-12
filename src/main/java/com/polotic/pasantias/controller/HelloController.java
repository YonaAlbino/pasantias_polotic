/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.excepciones.RecursoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
        @GetMapping("/hola")
        public ResponseEntity<String> saludar(@RequestParam String nombre){
        
           throw new  RecursoNoEncontradoException("Recurso no encontrado");
        
        }
    
    
}
