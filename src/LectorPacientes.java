import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorPacientes {

    public ArrayList<Paciente> leerPacientes(String rutaArchivo) throws IOException {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String linea;

        while ((linea = reader.readLine()) != null) {
            if (linea.isBlank()) {
                continue;
            }

            String[] partes = linea.split(",");

            if (partes.length != 3) {
                reader.close();
                throw new IllegalArgumentException("La linea no tiene el formato correcto: " + linea);
            }

            String nombre = partes[0].trim();
            String sintoma = partes[1].trim();
            char codigo = partes[2].trim().charAt(0);

            pacientes.add(new Paciente(nombre, sintoma, codigo));
        }

        reader.close();
        return pacientes;
    }
}
