package classes;

public class CartaCarro {

    private int velocidade;
    private int freio;
    private int aceleracao;
    private int turbo;
    private String nome;

    public CartaCarro() {}

    public CartaCarro(int velocidade, int freio, int aceleracao, int turbo, String nome) {
        this.velocidade = velocidade;
        this.freio = freio;
        this.aceleracao = aceleracao;
        this.turbo = turbo;
        this.nome = nome;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getFreio() {
        return freio;
    }

    public int getAceleracao() {
        return aceleracao;
    }

    public int getTurbo() {
        return turbo;
    }

    public String getNome() {
        return nome;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setFreio(int freio) {
        this.freio = freio;
    }

    public void setAceleracao(int aceleracao) {
        this.aceleracao = aceleracao;
    }

    public void setTurbo(int turbo) {
        this.turbo = turbo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    // @Override
    // public String toString() {
    //     return "CartaCarro [velocidade=" + velocidade + ", freio=" + freio + ", aceleracao=" + aceleracao + ", turbo="
    //             + turbo + "]";
    // }

    
}
