/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author einst
 */
public class Venta {
    
    private String codigoVenta;
    private Producto producto;
    private int cantidad;
    private Vendedor vendedor;

    public Venta() {
    }

    public Venta(String codigoVenta, Producto producto, int cantidad, Vendedor vendedor) {
        this.codigoVenta = codigoVenta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.vendedor = vendedor;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigoVenta=" + codigoVenta + ", producto=" + producto + ", cantidad=" + cantidad + ", vendedor=" + vendedor + '}';
    }
    
    public double calcularTotal(){
        
        return producto.getPrecio() * this.cantidad;
    }
    
    public void mostrarDetalle(){
        
        System.out.println("Detalle de la venta");
        
        System.out.println("codigo de venta:"+ this.codigoVenta);
        System.out.println("Nombre del producto:"+ this.producto.getNombre());
        System.out.println("Cantidad del producto:"+ this.cantidad);
        System.out.println("Nombre del vendedor:"+ this.vendedor.getNombre());
    }
}
