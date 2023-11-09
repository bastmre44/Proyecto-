
//Commit 4 (Subclase citas)
import java.io.*;
import java.util.*;
String java.util.Scanner.nextLine()

public class Citas extends Consulta {

    String archivo = "clientes.csv";

    public Citas(String usuario, String fecha, String diagnostico, String doctor, String farmacia, int hora,
            int total) {
        super(usuario, fecha, diagnostico, doctor, farmacia, hora, total);
    }

    public void guardarcitas(Consulta consulta) {

        try {
            FileWriter insertar = new FileWriter(Archivo, true);
            insertar.append(consulta.getUsuario());
            insertar.append(",");

            insertar.append(consulta.getFecha());
            insertar.append(",");

            insertar.append(consulta.getDiagn());
            insertar.append(",");

            insertar.append(consulta.getDoctor());
            insertar.append(",");

            insertar.append(consulta.getFarmacia());
            insertar.append(",");

            insertar.append(consulta.getHora());
            insertar.append(",");

            insertar.append(consulta.getTotal());
            insertar.append(",");
        } catch (IOException e) {
            System.err.println("Error, no se guardaron los datos: " + e.getMessage());
        }

    // Commit6 (solicitar información del usuario)
    public static void Consulta(String[] args){
        Scanner scan = new Scanner(System.in)
         
        // Menú
        System.out.println("Por favor, ingrese la información solicitada para registrar una cita");
        System.out.println("Nombre del paciente: ");
        String usuario = scan.nextLine();

        System.out.println("Fecha para la consulta (dd/mm/aa): ");
        String fecha = scan.nextLine();

        System.out.println("Diagnostico previo: ");
        String diagnostico = scan.nextLine();

        System.out.println("Doctor asignado: ");
        String doctor = scan.nextLine();

        System.out.println("Productos requeridos de la farmacia: ");
        String farmacia = scan.nextLine();

        System.out.println("Hora para la cita: ");
        int hora = scan.nextLine();

        System.out.println("Valor total previsto para la cita: ");
        int total = scan.nextLine();
    }
}
}
