import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Inventario {
    String archivo = "inventario.csv";
    Scanner leer = new Scanner(System.in);

    public void buscarProductoPorId(int idProducto) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0].trim());

                if (id == idProducto) {
                    System.out.println("ID del Producto: " + datos[0]);
                    System.out.println("Nombre: " + datos[1]);
                    System.out.println("Precio: " + datos[2]);
                    System.out.println("Stock: " + datos[3]);
                    System.out.println("Vendidos: " + datos[4]);
                    br.close();
                    return;
                }
            }

            br.close();
            System.out.println("No se encontró un producto con el ID especificado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarProducto() {
        try {
            FileWriter insertar = new FileWriter(archivo, true);
            System.out.print("Para ingresar un nuevo producto, proporciona la siguiente información: \n");

            System.out.print("Id del producto: ");
            String idInput = leer.nextLine();
            idInput = idInput.replaceAll("[^0-9]", "");
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

    public void actualizarExistenciaProducto(int idProducto, int cantidad) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            StringBuilder nuevoContenido = new StringBuilder();

            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0].trim());

                if (id == idProducto) {
                    int stockActual = Integer.parseInt(datos[3].trim());
                    int nuevoStock = stockActual + cantidad;
                    datos[3] = String.valueOf(nuevoStock);

                    System.out.println("Existencia actualizada del producto con ID " + idProducto + ": " + nuevoStock);
                }

                nuevoContenido.append(String.join(",", datos)).append("\n");
            }

            br.close();

            FileWriter escribir = new FileWriter(archivo);
            escribir.write(nuevoContenido.toString());
            escribir.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ejecutar() {
        while (true) {
            System.out.println("Selecciona una opción: ");
            System.out.println("1. Agregar un nuevo producto");
            System.out.println("2. Ver información de un producto");
            System.out.println("3. Actualizar existencia de un producto");
            System.out.println("4. Salir");

            int opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    System.out.print("Ingresa el ID del producto a buscar (números): ");
                    String idInput = leer.nextLine();
                    idInput = idInput.replaceAll("[^0-9]", "");
                    int idBuscado = Integer.parseInt(idInput);
                    buscarProductoPorId(idBuscado);
                    break;
                case 3:
                    System.out.print("Ingresa el ID del producto a actualizar (números): ");
                    String idInputActualizar = leer.nextLine();
                    idInputActualizar = idInputActualizar.replaceAll("[^0-9]", "");
                    int idActualizar = Integer.parseInt(idInputActualizar);

                    System.out.print("Ingresa la cantidad a agregar (positiva) o restar (negativa): ");
                    int cantidadActualizar = Integer.parseInt(leer.nextLine());

                    actualizarExistenciaProducto(idActualizar, cantidadActualizar);
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    leer.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.ejecutar();
    }
}
