/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Tipo_persona;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface ITipoPersonaService {

    public List<Tipo_persona> getTiposPersona();

    public void saveTipoPersona(Tipo_persona tipoPersona);

    public void deleteTipoPersona(Long id);

    public Tipo_persona findTipoPersona(Long id);

    public void editTipoPersona(Tipo_persona tipoPersona);
}
