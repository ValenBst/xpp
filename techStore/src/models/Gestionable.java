/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

/**
 *
 * @author einst
 */
public interface Gestionable {
    
    void listarEmpleados();
    void listarProductos();
    void registrarProductos(Producto prod);
    void registrarEmpleados(Empleado empl);
    void eliminarProducto(Producto prod);
    void eliminarEmpleado(Empleado empl);
}
