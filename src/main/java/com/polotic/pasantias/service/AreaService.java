/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Area;
import com.polotic.pasantias.repository.IAreaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService implements IAreaService {

    @Autowired
    private IAreaRepository areaRepo;

    @Override
    public List<Area> getAreas() {
        List<Area> listaArea = areaRepo.findAll();
        return listaArea;
    }

    @Override
    public void deleteArea(Long id) {
        areaRepo.deleteById(id);
    }

    @Override
    public Area findArea(Long id) {
        Area area = areaRepo.findById(id).orElse(null);
        if (area != null) {
            return area;
        } else {
            throw new RegistroNullException("El area que estas buscando no exite en la base de datos");
        }
    }

    @Override
    public void saveArea(Area area) {
        areaRepo.save(area);
    }

    @Override
    public void editArea(Area area) {
        this.saveArea(area);
    }

}
