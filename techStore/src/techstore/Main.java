/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package techstore;

import java.util.Scanner;
import models.Administrativo;
import models.Empleado;
import models.Manejadora;
import models.Producto;
import models.Vendedor;
import models.Venta;

/**
 *
 * @author einst
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Vendedor vend = new Vendedor();
        Administrativo adm = new Administrativo();
        Producto prod = new Producto();
        Manejadora mane = new Manejadora();
        Venta vent = new Venta();
        int opcion;
        int tipo;
        boolean ciclo = true;

        while (ciclo) {

            System.out.println("---MENU---");
            System.out.println("1. Registrar nuevo empleado");
            System.out.println("2. Registrar nuevo producto");
            System.out.println("3. Registrar una venta");
            System.out.println("4. Mostrar listado de empleados y productos");
            System.out.println("5. Calcular total de ventas realizadas");
            System.out.println("6. Salir del sistema");

            opcion = validaNumero("Eliga una opcion numerica");

            switch (opcion) {

                case 1:

                    System.out.println("has elegido la opcion 1");
                    System.out.println("Eliga las siguientes opciones de empleado");
                    System.out.println("1. Vendedor");
                    System.out.println("2. Administrativo");

                    tipo = validaNumero("Eliga una opcion numerica");

                    switch (tipo) {

                        case 1:

                            System.out.println("has elegido Vendedor");
                            vend.setRut(validaTexto("Ingresa rut del vendedor"));
                            vend.setNombre(validaTexto("Ingresa nombre del vendedor"));
                            vend.setSueldoBase(validaSueldo("Ingresa el sueldo del vendedor"));
                            mane.registrarEmpleados(vend);
                            System.out.println("Sueldo del vendedor");
                            System.out.println("INgresado con exito");
                            break;

                        case 2:

                            System.out.println("has elegido Administrativo");
                            adm.setNombre(validaTexto("Ingresa nombre del administrativo"));
                            adm.setRut(validaTexto("Ingresa rut del administrativo"));
                            adm.setHorasExtras(validaNumero("Ingresa horas extras trabajadas por el administrativo"));
                            adm.setSueldoBase(validaSueldo("Ingresa sueldo del administrativo"));
                            mane.registrarEmpleados(adm);

                            break;

                        default:
                            System.out.println("Opcion ingresada no valida");
                    }

                    break;

                case 2:

                    System.out.println("has elegido la opcion 2");
                    prod.setCodigo(validaTexto("Ingresa el codigo del producto"));
                    prod.setCategoria(validaTexto("Ingresa la categoria del prodcuto"));
                    prod.setNombre(validaTexto("Ingresa nombre del producto"));
                    prod.setPrecio(validaSueldo("Ingresa precio del producto"));
                    prod.setStock(validaNumero("Ingresa la cantidad de stock del producto"));
                    mane.registrarProductos(prod);

                    break;

                case 3:
                    System.out.println("has elegido la opcion 3");

                    String nombre = validaTexto("Ingresa el nombre del Vendedor asociado a la venta");

                    for (Empleado vendedor : mane.getEmpleados()) {

                        if (vendedor.getNombre().equalsIgnoreCase(nombre)) {

                            Vendedor vende = (Vendedor) vendedor;
                            vent.setVendedor(vende);
                            vent.setCodigoVenta(validaTexto("Ingrese el codigo de la venta"));

                            String producto = validaTexto("Ingresa codigo del producto");

                            for (Producto pro : mane.getProductos()) {

                                if (pro.getCodigo().equalsIgnoreCase(producto)) {

                                    vent.setProducto(pro);

                                    int cantidad = validaNumero("Ingresa cantidad del producto vendido");

                                    if (cantidad > pro.getStock()) {

                                        System.out.println("no hay suficiente stock para comprar");
                                    } else {
                                        vent.setCantidad(cantidad);
                                        int restante = pro.getStock() - cantidad;
                                        pro.actualizarStock(restante);

                                        mane.realizarVenta(vent);
                                        double vendido = vent.calcularTotal();
                                        vend.agregarVenta(vendido);
                                        vent.mostrarDetalle();
                                        System.out.println("Total Precio");
                                        System.out.println(vent.calcularTotal());

                                    }

                                } else {
                                    System.out.println("codigo del producto ingresado no existente");
                                }

                            }

                        } else {

                            System.out.println("Nombre del vendedor ingresado no valido");
                        }
                    }
                    break;

                case 4:

                    System.out.println("has elegido la opcion 4");
                    mane.listarEmpleados();
                    mane.listarProductos();
                    break;

                case 5:

                    System.out.println("has elegido la opcion 5");
                    System.out.println("Calculo total de ventas:");
                    System.out.println(mane.calcularTotalVentas());
                    ;
                    break;

                case 6:

                    System.out.println("Has salido del menu");
                    ciclo = false;
                    break;

                default:

                    System.out.println("Dato ingresado incorrectamente, intente nuevamente");
                    break;
            }
        }

    }

    private static String validaTexto(String msg) {

        while (true) {

            System.out.println(msg);
            String valor = sc.nextLine();

            if (valor.isEmpty() || valor.isBlank()) {

                System.out.println("El valor no puede estar vacio");

            } else {

                return valor;
            }
        }
    }

    private static boolean contieneNumeros(String valor) { //Juanito10

        String numeros = "1234567890";

        for (char i : valor.toCharArray()) {

            for (char j : numeros.toCharArray()) {

                if (i == j) {

                    return true;
                }
            }
        }
        return false;
    }

    private static int validaNumero(String msg) {

        while (true) {

            try {
                System.out.println(msg);
                int valor = sc.nextInt();
                sc.nextLine();

                if (valor < 0 || valor > 6) {

                    System.out.println("El valor debe ser mayor a 0 y menor o igual a 6");
                } else {

                    return valor;
                }
            } catch (Exception e) {

                System.out.println("El valor debe ser numerico.");
                sc.nextLine();
            }
        }
    }

    private static double validaSueldo(String msg) {

        while (true) {

            try {
                System.out.println(msg);
                double valor = sc.nextDouble();
                sc.nextLine();

                if (valor < 0) {

                    System.out.println("El valor debe ser mayor a 0");
                } else {

                    return valor;
                }
            } catch (Exception e) {

                System.out.println("El valor debe ser numerico.");
                sc.nextLine();
            }
        }
    }
}
