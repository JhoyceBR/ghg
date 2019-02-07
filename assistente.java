
import java.util.Date;


class assistente extends Funcionario{

    private String formacao;
    
    public assistente(int id, String nome, String cpf, String celular, String email, Date diaPresente, double salario, String formacao) {
        super( id, nome, cpf, celular, email, diaPresente, salario);
        this.formacao = formacao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
    
    
}
