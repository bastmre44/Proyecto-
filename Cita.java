import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cita { // crear clase
    String archivo = "clientes.csv";
    String usuario;
    LocalDate fecha;
    LocalTime hora;
    String diagnostico;
    String doctor;
    String farmacia;
    int total;

    public Cita(String usuario, LocalDate fecha, LocalTime hora, String diagnostico, String doctor, String farmacia, // crear
            // constructor
            int total) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.doctor = doctor;
        this.farmacia = farmacia;
        this.total = total;
    }

    public String getUsuario() { // crear getts
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

    // (hacerlo menú)

    public void guardar(Cita cita) { // metodo para guardar la info
        try {
            FileWriter insertar = new FileWriter(archivo, true);
            insertar.append(cita.getUsuario());
            insertar.append(",");
            insertar.append(cita.getFecha().toString());
            insertar.append(",");
            insertar.append(String.valueOf(cita.getHora()));
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
        } catch (IOException e) {
            System.err.println("Error, no se guardaron los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) { // main para que corra el programa y solicite la info
        Scanner leer = new Scanner(System.in);
        System.out.print("Para ingresar una nueva cita, proporciona la siguiente información: \n");
        System.out.print("Usuario: ");
        String usuario = leer.nextLine();
        System.out.print("Fecha (AAAA-MM-DD): ");
        String fechaStr = leer.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);
        System.out.print("Hora (HH:MM): ");
        LocalTime hora = LocalTime.parse(leer.nextLine());
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM");
        System.out.print("Diagnóstico: ");
        String diagnostico = leer.nextLine();
        System.out.print("Doctor: ");
        String doctor = leer.nextLine();
        System.out.print("Farmacia: ");
        String farmacia = leer.nextLine();
        System.out.print("Total: ");
        int total = Integer.parseInt(leer.nextLine());

        leer.close();

        Cita cita = new Cita(usuario, fecha, hora, diagnostico, doctor, farmacia, total);
        cita.guardar(cita);

    }
}