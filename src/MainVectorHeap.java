import java.io.IOException;

public class MainVectorHeap {

    public static void main(String[] args) {
        String rutaArchivo = "pacientes.txt";

        if (args.length > 0) {
            rutaArchivo = args[0];
        }

        LectorPacientes lector = new LectorPacientes();
        VectorHeap<Paciente> colaPacientes = new VectorHeap<>();

        try {
            for (Paciente paciente : lector.leerPacientes(rutaArchivo)) {
                colaPacientes.add(paciente);
            }

            if (colaPacientes.isEmpty()) {
                System.out.println("No hay pacientes en espera.");
                return;
            }

            System.out.println("Pacientes en orden de atencion con VectorHeap:");

            while (!colaPacientes.isEmpty()) {
                Paciente siguientePaciente = colaPacientes.remove();
                System.out.println(siguientePaciente);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de pacientes.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
