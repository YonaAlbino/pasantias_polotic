/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Provincia;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface IProvinciaService {

    public List<Provincia> getProvincia();

    public void saveProvincia(Provincia provincia);

    public void deleteProvincia(Long id);

    public Provincia findProvincia(Long id);

    public void editProvincia(Provincia provincia);
}
