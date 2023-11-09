import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class historialclic {
    private String archivoClientes = "clientes.csv";

    public void mostrarHistorialPorCliente(String nombreCliente) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoClientes));
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String usuario = datos[0].trim(); // El índice 0 corresponde a la columna "Usuario" 

                if (usuario.equalsIgnoreCase(nombreCliente)) {
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
                System.out.println("No se encontraron registros para el cliente " + nombreCliente);
            } else {
                System.out.println("Total de registros encontrados: " + contador);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        historialclic historial = new historialclic();

        if (args.length > 0) {
            historial.mostrarHistorialPorCliente(args[0]);
        } else {
            System.out.println("Por favor, ingresa el nombre de cliente como argumento.");
        }
    }
}
