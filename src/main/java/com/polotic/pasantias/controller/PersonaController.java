/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;


import com.polotic.pasantias.model.Persona;
import com.polotic.pasantias.service.IPersonaService;
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
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IPersonaService persoServi;

    @PostMapping("/crear")
    public ResponseEntity<String> savePersona(@RequestBody Persona persona) {
        persoServi.savePersona(persona);
        return new ResponseEntity<>("La persona fue creada exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> editPersona(@RequestBody Persona persona) {
        persoServi.editPersona(persona);
        return new ResponseEntity<>("La persona fue modificada exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> deletePersona(@RequestParam Long id) {
        persoServi.deletePersona(id);
        return new ResponseEntity<>("La persona fue eliminada exitosamente", HttpStatus.OK);
    }

    @GetMapping("/traer/todas")
    public ResponseEntity<List<Persona>> getPersonas() {
        List<Persona> listaPersonas = persoServi.getPersonas();
        return new ResponseEntity<>(listaPersonas, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Persona> findPersona(@RequestParam Long id) {
        Persona persona = persoServi.findPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.FOUND);
    }
}
