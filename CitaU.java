import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CitaU {
    String archivo = "clientes.csv";
    String usuario;
    LocalDate fecha;
    LocalTime hora;
    String diagnostico;
    String doctor;
    String farmacia;
    int total;

    public CitaU(String usuario, LocalDate fecha, LocalTime hora, String diagnostico, String doctor, String farmacia,
            int total) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.doctor = doctor;
        this.farmacia = farmacia;
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public int getTotal() {
        return total;
    }

    public void guardarCitaU(CitaU cita) {
        if (!validar(cita)) {
            try {
                FileWriter insertar = new FileWriter(archivo, true);
                insertar.append(cita.getUsuario());
                insertar.append(",");
                insertar.append(cita.getFecha().toString());
                insertar.append(",");
                insertar.append(cita.getHora().toString());
                insertar.append(",");
                insertar.append(cita.getDiagnostico());
                insertar.append(",");
                insertar.append(cita.getDoctor());
                insertar.append(",");
                insertar.append(cita.getFarmacia());
                insertar.append(",");
                insertar.append(String.valueOf(cita.getTotal()));
                insertar.append("\n");
                insertar.flush();
                insertar.close();
                System.out.println("Los datos de la cita han sido guardados exitosamente.");

                // Regresar al menú de usuarios
                MenuU.main(new String[]{});
            } catch (IOException e) {
                System.err.println("Error, no se guardaron los datos: " + e.getMessage());
            }
        } else {
            System.out.println("Cita no disponible. La fecha y hora ya están ocupadas por otra cita.");
        }
    }

    private boolean validar(CitaU citaa) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Usuario, Fecha, Hora, Diagnostico, Doctor, Farmacia, Total")) {
                    continue;
                }

                String[] columnas = linea.split(",");

                try {
                    LocalDate fechaE = LocalDate.parse(columnas[1].trim());
                    LocalTime horaE = LocalTime.parse(columnas[2].trim());

                    if (fechaE.equals(citaa.getFecha()) && horaE == citaa.getHora()) {
                        return true;
                    }
                } catch (DateTimeParseException e) {
                    System.err.println(" ");
                }
            }
        } catch (IOException e) {
            System.err.println("Error. " + e.getMessage());
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Para ingresar una nueva cita, proporciona la siguiente información: \n");
        System.out.print("Usuario: ");
        String usuario = leer.nextLine();

        LocalDate fecha = null;
        while (fecha == null) {
            try {
                System.out.print("Fecha (AAAA-MM-DD): ");
                String fechaStr = leer.nextLine();
                fecha = LocalDate.parse(fechaStr);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Inténtalo de nuevo.");
            }
        }

        LocalTime hora = null;
        while (hora == null) {
            try {
                System.out.print("Hora (HH:MM): ");
                String horaStr = leer.nextLine();
                hora = LocalTime.parse(horaStr);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de hora incorrecto. Inténtalo de nuevo.");
            }
        }

        System.out.print("Diagnóstico: ");
        String diagnostico = leer.nextLine();
        System.out.print("Doctor: ");
        String doctor = leer.nextLine();
        System.out.print("Farmacia: ");
        String farmacia = leer.nextLine();
        System.out.print("Total: ");
        int total = Integer.parseInt(leer.nextLine());

        // leer.close();

        CitaU cita = new CitaU(usuario, fecha, hora, diagnostico, doctor, farmacia, total);
        cita.guardarCitaU(cita);
    }
}
