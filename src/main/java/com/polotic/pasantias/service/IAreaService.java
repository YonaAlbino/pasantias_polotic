/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Area;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface IAreaService {
    
    public List<Area> getAreas();
    
    public void saveArea(Area area);
    
    public void deleteArea(Long id);
    
    public Area findArea(Long id);
    
    public void editArea(Area area);
    
}
