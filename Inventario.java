import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Inventario {
    int id_producto;
    String nombre;
    int precio;
    int stock;
    int vendidos;
    String archivo = "inventario.csv";

    public Inventario(int id_producto, String nombre, int precio, int stock, int vendidos) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.vendidos = vendidos;
    }

    public int getId() {
        return id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void agregarproducto() {
        try {
            FileWriter insertar = new FileWriter(archivo, true);
            System.out.print("Para ingresar un nuevo producto, proporciona la siguiente información: \n");
            insertar.append(String.valueOf(getId()));
            insertar.append(",");
            insertar.append(getNombre());
            insertar.append(",");
            insertar.append(String.valueOf(getPrecio()));
            insertar.append(",");
            insertar.append(String.valueOf(getStock()));
            insertar.append(",");
            insertar.append(String.valueOf(getVendidos()));
            insertar.append("\n");
            insertar.flush();
            insertar.close();
            System.out.println("El producto se ha guardado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error, no se guardaron los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Selecciona una opción: ");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Ver información de un producto");
        int opcion = Integer.parseInt(leer.nextLine());

        if (opcion == 1) {
            System.out.print("Id del producto: ");
            int id = Integer.parseInt(leer.nextLine());
            System.out.print("Nombre: ");
            String nombre = leer.nextLine();
            System.out.print("Precio: ");
            int precio = Integer.parseInt(leer.nextLine());
            System.out.print("Cuántos hay en stock: ");
            int stock = Integer.parseInt(leer.nextLine());
            System.out.print("Cuantos se han vendido: ");
            int vendidos = Integer.parseInt(leer.nextLine());

            Inventario inventario = new Inventario(id, nombre, precio, stock, vendidos);
            inventario.agregarproducto();
        }
        leer.close();
    }
}
