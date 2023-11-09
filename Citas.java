
//Commit 4 (Subclase citas)
import java.io.*;
import java.util.*;

public class Citas extends Consulta {

    String archivo = "clientes.csv";

    public Citas(String usuario, String fecha, String diagnostico, String doctor, String farmacia, int hora,
            int total) {
        super(usuario, fecha, diagnostico, doctor, farmacia, hora, total);
    }
// Commit 5 (guardar datos del usuario)
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
    }

    

}
