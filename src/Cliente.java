public class Cliente implements Pessoa{

    private final String nome;
    private final String cpf;
    private final String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;


        this.cpf = cpf;


        this.email = email;
    }



    public String getNome() {
        return nome;
    }



    public String getCpf() {
        return cpf;
    }



    public String getEmail() {
        return email;
    }




    @Override
    public String nome() {
        return nome;
    }

    @Override
    public String cpf() {
        return cpf;
    }

    @Override
    public String email() {
        return email;
    }

}
