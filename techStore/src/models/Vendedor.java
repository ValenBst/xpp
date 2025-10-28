/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author einst
 */
public class Vendedor extends Empleado {

    private ArrayList<Double> ventasRealizadas = new ArrayList<>();

    public Vendedor() {
        
    }

    public Vendedor(String rut, String nombre, double sueldoBase) {
        super(rut, nombre, sueldoBase);
    }

    public ArrayList<Double> getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(ArrayList<Double> ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public String toString() {

        return "Vendedor{" + "rut=" + super.rut + ", nombre=" + super.nombre + ", sueldoBase=" + super.sueldoBase + 
                ",ventas ="+ "ventas realizadas:"+ this.ventasRealizadas +'}';
    }

    @Override
    public double calcularSueldo() {

        double comisionTotal = 0;

        for (double ventas : this.ventasRealizadas) {

            comisionTotal += ventas * 0.05;
        }

        return super.sueldoBase + comisionTotal;

    }
    
    public void agregarVenta(double venta){
        
        this.ventasRealizadas.add(venta);
    }

}
