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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalTime;
import java.util.Date;
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
public class Reunion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_reunion;

    private String objetivo;
    private String tema;
    private String propuesta;
    private Date fecha;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;

    @OneToOne
    @JoinColumn(name = "lugar_de_Realizacion",
            referencedColumnName = "id_lugar_realizacion")
    private Lugar_realizacion unLugar_realizacion;

    @OneToOne
    @JoinColumn(name = "modelo_pasante",
            referencedColumnName = "id_modelo_pasante")
    private Modelo_pasante unModelo_pasante;

    @OneToOne
    @JoinColumn(name = "institucion",
            referencedColumnName = "id_institucion")
    private Institucion unaInstitucion;
    
    @OneToMany(mappedBy = "reunion")
    private List<Persona> listaPersonas;
    
}
