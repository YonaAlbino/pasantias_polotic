/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Contacto;
import com.polotic.pasantias.model.Institucion;
import com.polotic.pasantias.model.Localidad;
import com.polotic.pasantias.model.Nivel;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface IIinstitucionService {
    public List<Institucion> getInstituciones();
    
    public void saveInstitucion(Institucion institucion);
}
