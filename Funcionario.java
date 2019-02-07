package sistemadentista;

import java.util.Date;


class Funcionario extends Pessoa{
    
    private double salario;
    
    public Funcionario(int id, String nome, String cpf, String celular, String email, Date diaPresente, double salario) {
        super(id, nome, cpf, celular, email, diaPresente);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}