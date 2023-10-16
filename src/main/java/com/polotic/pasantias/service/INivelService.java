/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Institucion;
import com.polotic.pasantias.model.Nivel;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface INivelService {
    
    public void saveNivel(Nivel nivel);
    
    public List<Nivel> getNiveles();
    
    public Nivel findNivel(Long id);
    
    public void editNivel(Nivel nivel);
    
    public void deleteNivel(Long id);
    
}
