public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = Character.toUpperCase(codigoEmergencia);

        if (this.codigoEmergencia < 'A' || this.codigoEmergencia > 'E') {
            throw new IllegalArgumentException("El codigo de emergencia debe estar entre A y E.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    private int prioridadNumerica() {
        return codigoEmergencia - 'A';
    }

    @Override
    public int compareTo(Paciente otroPaciente) {
        return Integer.compare(this.prioridadNumerica(), otroPaciente.prioridadNumerica());
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
