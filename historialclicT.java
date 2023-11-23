import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class historialclicT {
    private String archivoClientes = "clientes.csv";

    public void mostrarHistorialPorUsuario(String nombreUsuario) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoClientes));
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String usuario = datos[0].trim(); // El índice 0 corresponde a la columna "Usuario" 

                if (usuario.equalsIgnoreCase(nombreUsuario)) {
                    // Mostrar todos los datos del registro del historial clínico.
                    System.out.println("Usuario: " + datos[0]);
                    System.out.println("Fecha: " + datos[1]);
                    System.out.println("Hora: " + datos[2]);
                    System.out.println("Diagnóstico: " + datos[3]);
                    System.out.println("Doctor: " + datos[4]);
                    System.out.println("Farmacia: " + datos[5]);
                    System.out.println("Total: " + datos[6]);
                    System.out.println("------------");

                    contador++;
                }
            }

            br.close();

            if (contador == 0) {
                System.out.println("No se encontraron registros para el usuario " + nombreUsuario);
            } else {
                System.out.println("Total de registros encontrados: " + contador);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        historialclicT historial = new historialclicT();
        Scanner leer = new Scanner(System.in);

        System.out.print("Por favor, ingresa el nombre de usuario: ");
        String nombreUsuario = leer.nextLine();
        historial.mostrarHistorialPorUsuario(nombreUsuario);

        // Regresar al menú principal
        MenuT.main(new String[]{});

        leer.close();
    }
}
