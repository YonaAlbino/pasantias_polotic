/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Persona;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface IPersonaService {

    public List<Persona> getPersonas();

    public void savePersona(Persona persona);

    public void deletePersona(Persona id);

    public Persona findPersona(Long id);

    public void editPersona(Persona persona);
}
