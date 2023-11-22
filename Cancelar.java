import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Cancelar {
    private String archivo = "clientes.csv";
    //Método para cancelar una cita
    public Cancelar() {
        // Constructor 
    }

    public void cancelarCita(LocalDate fecha, int hora) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            StringBuilder datos = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Usuario, Fecha, Hora, Diagnostico, Doctor, Farmacia, Total")) {
                    datos.append(linea).append("\n");
                    continue;
                }

                String[] columnas = linea.split(",");

                try {
                    LocalDate fechaCita = LocalDate.parse(columnas[1].trim());
                    int horaCita = Integer.parseInt(columnas[2].trim());

                    if (!(fechaCita.equals(fecha) && horaCita == hora)) {
                        datos.append(linea).append("\n");
                    }
                } catch (DateTimeParseException e) {
                    System.err.println("Error al procesar la fecha: " + e.getMessage());
                }
            }

            br.close();

            FileWriter escribir = new FileWriter(archivo);
            escribir.write(datos.toString());
            escribir.close();

            System.out.println("La cita ha sido cancelada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al cancelar la cita: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("Ingrese la fecha de la cita a cancelar (AAAA-MM-DD): ");
        String fechaStr = leer.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        System.out.print("Ingrese la hora de la cita a cancelar: ");
        int hora = Integer.parseInt(leer.nextLine());

        leer.close();
        // instancia de la clase CancelarCita y cancelar la cita
        Cancelar cancelador = new Cancelar();
        cancelador.cancelarCita(fecha, hora);
    }
}
