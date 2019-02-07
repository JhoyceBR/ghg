package sistemadentista;

import java.util.Date;


class Dentista extends Funcionario{
    private int CRO;
    private Boolean atendendo;

    public Dentista(int id, String nome, String cpf, String celular, String email, Date diaPresente, double salario, int CRO, Boolean atendendo) {
        super(id, nome, cpf, celular, email, diaPresente, salario);
        this.CRO = CRO;
        this.atendendo = atendendo;
    }
    
    public int getCRO() {
        return CRO;
    }

    public void setCRO(int CRO) {
        this.CRO = CRO;
    }

    public Boolean getAtendendo() {
        return atendendo;
    }

    public void setAtendendo(Boolean atendendo) {
        this.atendendo = atendendo;
    }
    
    
    
}