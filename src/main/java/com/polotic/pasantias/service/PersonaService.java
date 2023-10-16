/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Persona;
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
        if (!listaPersonas.isEmpty()) 
            return listaPersonas;
         else 
            throw new ListaVaciaException("La lista de personas se encuentra vacia");
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepo.findById(id).orElse(null);
        if(persona != null)
            return persona;
        else
            throw new RegistroNullException("La persona que estas buscando no existe en la base de datos");
    }

    public void savePersona(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public void editPersona(Persona persona) {
        this.savePersona(persona);
    }

}
