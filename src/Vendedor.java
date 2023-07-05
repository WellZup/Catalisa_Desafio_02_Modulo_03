public class Vendedor implements Pessoa{
    private final String nome;
    private final String cpf;
    private final String email;

    public Vendedor(String nome, String cpf, String email) {
        this.nome = nome;



        this.cpf = cpf;

        if (!validarEmail(email)) {
            throw new IllegalArgumentException("E-mail inválido para o vendedor: " + email);
        }
        this.email = email;
    }




    private boolean validarEmail(String email) {
        return email.contains("@");
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

