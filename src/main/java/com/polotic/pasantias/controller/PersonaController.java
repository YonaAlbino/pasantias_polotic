/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Localidad;
import com.polotic.pasantias.model.Lugar_realizacion;
import com.polotic.pasantias.model.Modelo_pasante;
import com.polotic.pasantias.model.Persona;
import com.polotic.pasantias.model.Provincia;
import com.polotic.pasantias.model.Reunion;
import com.polotic.pasantias.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService persoServi;

    @PostMapping("/crear")
    public ResponseEntity<String> savePersona(@RequestParam String nombre, @RequestParam String apellido, @RequestParam int dni, @RequestParam String cuil,
            @RequestParam String cv, @RequestParam String direccion, @RequestParam String edad,
            @RequestParam(required = false) Reunion reunion, @RequestParam(required = false) Modelo_pasante unModelo_pasante,
            @RequestParam(required = false) Provincia unaProvincia, @RequestParam(required = false) Localidad unaLolidad,
            @RequestParam(required = false) Lugar_realizacion id_tipo_persona) {

        persoServi.savePersona(nombre, apellido, dni, cuil, cv, direccion, edad, reunion, unModelo_pasante, unaProvincia, unaLolidad, id_tipo_persona);

        return new ResponseEntity<>("La persona fue creada exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("actualizar")
    public ResponseEntity<String> editPersona(@RequestParam Long id, @RequestParam String nombre, @RequestParam String apellido, @RequestParam int dni, @RequestParam String cuil,
            @RequestParam String cv, @RequestParam String direccion, @RequestParam String edad,
            @RequestParam(required = false) Reunion reunion, @RequestParam(required = false) Modelo_pasante unModelo_pasante,
            @RequestParam(required = false) Provincia unaProvincia, @RequestParam(required = false) Localidad unaLolidad,
            @RequestParam(required = false) Lugar_realizacion id_tipo_persona) {

        persoServi.editPersona(id, nombre, apellido, dni, cuil, cv, direccion, edad, reunion, unModelo_pasante, unaProvincia, unaLolidad, id_tipo_persona);

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

        if (!listaPersonas.isEmpty()) {
            return new ResponseEntity<>(listaPersonas, HttpStatus.OK);
        } else {
            throw new ListaVaciaException("La lista de personas esta vacia");
        }
    }

    @GetMapping("/buscar/persona")
    public ResponseEntity<Persona> findPersona(@RequestParam Long id) {

        Persona persona = persoServi.findPersona(id);

        if (persona != null) {
            return new ResponseEntity<>(persona, HttpStatus.FOUND);
        } else {
            throw new RegistroNullException("La persona no existe en la base de datos");
        }

    }

}
