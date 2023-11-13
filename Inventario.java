import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Inventario {
    String archivo = "inventario.csv";
    Scanner leer = new Scanner(System.in); // Declarar Scanner como variable de instancia
    // Método para buscar un producto por ID

    public void buscarProductoPorId(int idProducto) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            // Omitir la primera línea (encabezados)
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0].trim());

                if (id == idProducto) {
                    // Mostrar la información del producto encontrado.
                    System.out.println("ID del Producto: " + datos[0]);
                    System.out.println("Nombre: " + datos[1]);
                    System.out.println("Precio: " + datos[2]);
                    System.out.println("Stock: " + datos[3]);
                    System.out.println("Vendidos: " + datos[4]);
                    br.close(); // Cerrar el archivo después de encontrar el producto.
                    return;
                }
            }

            br.close();
            System.out.println("No se encontró un producto con el ID especificado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para agregar un nuevo producto al inventario
    public void agregarProducto() {
        try {
            FileWriter insertar = new FileWriter(archivo, true);
            System.out.print("Para ingresar un nuevo producto, proporciona la siguiente información: \n");

            System.out.print("Id del producto: ");
            String idInput = leer.nextLine();
            idInput = idInput.replaceAll("[^0-9]", ""); // Eliminar caracteres no numéricos
            int id = Integer.parseInt(idInput);

            System.out.print("Nombre: ");
            String nombre = leer.nextLine();
            System.out.print("Precio: ");
            int precio = Integer.parseInt(leer.nextLine());
            System.out.print("Cuántos hay en stock: ");
            int stock = Integer.parseInt(leer.nextLine());
            System.out.print("Cuantos se han vendido: ");
            int vendidos = Integer.parseInt(leer.nextLine());

            insertar.append(String.valueOf(id));
            insertar.append(",");
            insertar.append(nombre);
            insertar.append(",");
            insertar.append(String.valueOf(precio));
            insertar.append(",");
            insertar.append(String.valueOf(stock));
            insertar.append(",");
            insertar.append(String.valueOf(vendidos));
            insertar.append("\n");
            insertar.flush();
            insertar.close();
            System.out.println("El producto se ha guardado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error, no se guardaron los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        System.out.println("Selecciona una opción: ");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Ver información de un producto");

        int opcion = Integer.parseInt(inventario.leer.nextLine());
        int idBuscado = 0;

        if (opcion == 1) {
            inventario.agregarProducto(); // Llamar al método para agregar un producto
        } else if (opcion == 2) {
            System.out.print("Ingresa el ID del producto a buscar (números): ");
            String idInput = inventario.leer.nextLine();
            idInput = idInput.replaceAll("[^0-9]", ""); // Eliminar caracteres no numéricos
            idBuscado = Integer.parseInt(idInput); // Llamar al método para buscar un producto por ID

            inventario.buscarProductoPorId(idBuscado);
        } else {
            System.out.println("Opción no válida.");
        }

        inventario.leer.close(); // Cerrar el Scanner
    }
}
