/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_provincia;
    
    private String nombre;
    
    @OneToMany(mappedBy = "unaProvincia")
    private List<Localidad> listaLocalidades;
    
    @OneToMany(mappedBy = "unaProvincia")
    private List<Persona> listaPersonas;
}
