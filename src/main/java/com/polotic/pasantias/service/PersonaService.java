/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Localidad;
import com.polotic.pasantias.model.Lugar_realizacion;
import com.polotic.pasantias.model.Modelo_pasante;
import com.polotic.pasantias.model.Persona;
import com.polotic.pasantias.model.Provincia;
import com.polotic.pasantias.model.Reunion;
import com.polotic.pasantias.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private IPersonaRepository personaRepo;
    
    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = personaRepo.findAll();
        return listaPersonas;
    }
    
    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepo.findById(id).orElse(null);
        return persona;
    }
    
    @Override
    public void savePersona(String nombre, String apellido, int dni, String cuil,
            String cv, String direccion, String edad,
            Reunion reunion, Modelo_pasante unModelo_pasante, Provincia unaProvincia,
            Localidad unaLolidad, Lugar_realizacion id_tipo_persona) {
        
        Persona persona = Persona.builder()
                .nombre(nombre)
                .apellido(apellido)
                .cuil(cuil)
                .cv(cv)
                .direccion(direccion)
                .dni(dni)
                .edad(edad)
                .id_tipo_persona(id_tipo_persona)
                .reunion(reunion)
                .unModelo_pasante(unModelo_pasante)
                .unaLolidad(unaLolidad)
                .unaProvincia(unaProvincia)
                .build();
        
        personaRepo.save(persona);
        
    }
    
    public void savePersona(Persona persona) {
        personaRepo.save(persona);
    }
    
    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }
    
    @Override
    public void editPersona(Long id_persona, String nombre, String apellido, int dni, String cuil, String cv, String direccion, String edad, Reunion reunion,
            Modelo_pasante unModelo_pasante, Provincia unaProvincia, Localidad unaLolidad, Lugar_realizacion id_tipo_persona) {
        
        Persona persona = this.findPersona(id_persona);
        
        persona.setApellido(apellido);
        persona.setCuil(cuil);
        persona.setCv(cv);
        persona.setDireccion(direccion);
        persona.setDni(dni);
        persona.setEdad(edad);
        persona.setId_persona(id_persona);
        persona.setId_tipo_persona(id_tipo_persona);
        persona.setNombre(nombre);
        persona.setReunion(reunion);
        persona.setUnModelo_pasante(unModelo_pasante);
        persona.setUnaLolidad(unaLolidad);
        persona.setApellido(apellido);
        
        this.savePersona(persona);
    }
    
}
