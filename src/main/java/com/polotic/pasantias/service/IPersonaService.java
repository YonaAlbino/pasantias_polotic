/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Localidad;
import com.polotic.pasantias.model.Lugar_realizacion;
import com.polotic.pasantias.model.Modelo_pasante;
import com.polotic.pasantias.model.Persona;
import com.polotic.pasantias.model.Provincia;
import com.polotic.pasantias.model.Reunion;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface IPersonaService {

    public List<Persona> getPersonas();

    public void savePersona(Persona persona);

    public void deletePersona(Long id);

    public Persona findPersona(Long id);

    public void editPersona(Persona persona);
}
