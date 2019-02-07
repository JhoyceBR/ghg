package sistemadentista;


public class Consulta {
    private Paciente paciente;
    private Dentista dentistas;
    private String medicamento;
    private String exame;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentistas() {
        return dentistas;
    }

    public void setDentistas(Dentista dentistas) {
        this.dentistas = dentistas;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

   
}