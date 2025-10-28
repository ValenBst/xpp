/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author einst
 */
public class Administrativo extends Empleado {
    
    private int horasExtras;

    public Administrativo() {
    }

    public Administrativo(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public Administrativo(int horasExtras, String rut, String nombre, double sueldoBase) {
        super(rut, nombre, sueldoBase);
        this.horasExtras = horasExtras;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public String toString() {
        return "Administrativo{" + "rut=" + rut + ", nombre=" + nombre + ", sueldoBase=" + sueldoBase + "Horas extras: "+ this.horasExtras+'}';
    }

    @Override
    public double calcularSueldo() {
        
        return super.sueldoBase + 20000 * this.horasExtras;
        
    }
    
    
    
}
