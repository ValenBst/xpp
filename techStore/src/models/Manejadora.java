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
public class Manejadora implements Gestionable {

    ArrayList<Empleado> empleados = new ArrayList<>();
    ArrayList<Producto> productos = new ArrayList<>();
    ArrayList<Venta> ventas = new ArrayList<>();

    public Manejadora() {
    }

    

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public void realizarVenta(Venta venta) {
        this.ventas.add(venta);
    }

    @Override
    public String toString() {
        return "Manejadora{" + "empleados=" + empleados + ", productos=" + productos + ", ventas=" + ventas + '}';
    }

    
    @Override
    public void listarEmpleados() {

        System.out.println("Lista de empleados");

        for (Empleado empl : empleados) {

            System.out.println(empl);
        }
    }

    @Override
    public void listarProductos() {

        System.out.println("Lista de producto");

        for (Producto prod : productos) {

            System.out.println(prod);
        }
    }

    @Override
    public void registrarProductos(Producto prod) {

        this.productos.add(prod);
    }

    @Override
    public void registrarEmpleados(Empleado empl) {

        this.empleados.add(empl);
    }

    @Override
    public void eliminarProducto(Producto prod) {

        if (this.productos.contains(prod)) {

            this.productos.remove(prod);
        } else {

            System.out.println("El producto ingresado no se encuentra en la lista");
        }

    }

    @Override
    public void eliminarEmpleado(Empleado empl) {

        if (this.empleados.contains(empl)) {

            this.empleados.remove(empl);
        } else {

            System.out.println("El empleado ingresado no se encuentra en la lista");
        }
    }

    public double calcularTotalVentas() {

        double total = 0;

        for (Venta vent : this.ventas) {

            total += vent.calcularTotal();
        }

        return total;
    }

}
