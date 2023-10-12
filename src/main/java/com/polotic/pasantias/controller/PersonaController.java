/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.model.Localidad;
import com.polotic.pasantias.model.Lugar_realizacion;
import com.polotic.pasantias.model.Modelo_pasante;
import com.polotic.pasantias.model.Provincia;
import com.polotic.pasantias.model.Reunion;
import com.polotic.pasantias.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private PersonaService persoServi;
    
    @PostMapping("/crear")
    public void savePersona(@RequestParam String nombre, @RequestParam String apellido, @RequestParam int dni, @RequestParam String cuil,
                            @RequestParam String cv, @RequestParam String direccion, @RequestParam String edad,
                            @RequestParam(required = false) Reunion reunion, @RequestParam(required = false)  Modelo_pasante unModelo_pasante,
                            @RequestParam(required = false) Provincia unaProvincia,  @RequestParam(required = false) Localidad unaLolidad,
                            @RequestParam(required = false) Lugar_realizacion id_tipo_persona){
        
        persoServi.savePersona(nombre, apellido, dni, cuil, cv, direccion, edad, reunion, unModelo_pasante, unaProvincia, unaLolidad, id_tipo_persona);
    }
    
}
