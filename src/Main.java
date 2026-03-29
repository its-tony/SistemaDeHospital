import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        String rutaArchivo = "pacientes.txt";

        if (args.length > 0) {
            rutaArchivo = args[0];
        }

        LectorPacientes lector = new LectorPacientes();
        PriorityQueue<Paciente> colaPacientes = new PriorityQueue<>();

        try {
            for (Paciente paciente : lector.leerPacientes(rutaArchivo)) {
                colaPacientes.add(paciente);
            }

            if (colaPacientes.isEmpty()) {
                System.out.println("No hay pacientes en espera.");
                return;
            }

            System.out.println("Pacientes en orden de atencion:");

            while (!colaPacientes.isEmpty()) {
                Paciente siguientePaciente = colaPacientes.poll();
                System.out.println(siguientePaciente);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de pacientes.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
