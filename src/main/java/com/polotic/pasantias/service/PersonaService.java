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
import org.springframework.web.bind.annotation.RequestParam;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editPersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public void deletePersona(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
