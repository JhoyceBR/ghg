package sistemadentista;

import java.util.Date;

class Paciente extends Pessoa{


    private double preco;
    

    public Paciente(int id,String nome, String cpf, String celular, String email, Date diaPresente, double preco) {
        super(id, nome, cpf, celular, email, diaPresente);
        this.preco = preco;
    
    }    

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

   
}