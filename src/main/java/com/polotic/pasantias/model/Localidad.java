/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_localidad;

    private String nombre;

    @OneToMany(mappedBy = "unaLocalidad")
    private List<Institucion> listaInstituciones;

    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia unaProvincia;

    @OneToMany(mappedBy = "unaLolidad")
    private List<Persona> listaPersonas;
}
