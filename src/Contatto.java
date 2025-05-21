//nome, numero mail

public class Contatto {
    private String nome;
    private long numero;
    private String email;

    public Contatto(String nome, long numero, String email){
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    public String getNome() { return nome; }
    public long getNumero() { return numero; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return nome + " | " + numero + " | " + email;
    }
}
