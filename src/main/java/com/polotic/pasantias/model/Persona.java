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
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_persona;

    private String nombre;
    private String apellido;
    private int dni;
    private String cuil;
    private String cv;
    private String direccion;
    private int edad;

    @ManyToOne
    @JoinColumn(name = "id_reunion")
    private Reunion reunion;

    @ManyToOne
    @JoinColumn(name = "id_modelo_pasante")
    private Modelo_pasante unModelo_pasante;

    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia unaProvincia;

    @ManyToOne
    @JoinColumn(name = "id_localidad")
    private Localidad unaLolidad;

    @OneToOne
    @JoinColumn(name = "id_tipo_persona",
            referencedColumnName = "id_lugar_realizacion")
    private Lugar_realizacion id_tipo_persona;
}
