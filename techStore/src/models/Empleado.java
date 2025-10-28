/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author einst
 */
public abstract class Empleado {
    
    protected String rut,nombre;
    protected double sueldoBase;

    public Empleado() {
    }

    public Empleado(String rut, String nombre, double sueldoBase) {
        this.rut = rut;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return "Empleado{" + "rut=" + rut + ", nombre=" + nombre + ", sueldoBase=" + sueldoBase + '}';
    }
    
    public abstract double calcularSueldo(); 
    
}
