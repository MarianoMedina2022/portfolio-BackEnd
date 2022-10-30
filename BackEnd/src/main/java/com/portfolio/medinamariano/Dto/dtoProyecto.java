/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.medinamariano.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author maria
 */
public class dtoProyecto {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    private Number img;
    
    // Constructor
    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descripcionP, Number img) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
	this.img = img;
    }
    
    // Getter and Setter
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

	public Number getImg() {
		return img;
	}

	public void setImg(Number img) {
		this.img = img;
	}
    
    
    
}
