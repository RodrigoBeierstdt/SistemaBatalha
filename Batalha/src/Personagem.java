import java.util.Random;

public class Personagem {

    private String nome;
    private int vidaMaxima;
    private int ataque;
    private int defesa;
    private int vidaAtual;
    private boolean desviando = false;
    private Random random = new Random();
    private boolean defendendo = false;

    int getVidaAtual() {
        return vidaAtual;
    }

    boolean estaVivo() {
        return vidaAtual > 0;
    }

    void receberDano(int dano) {

        if (desviando) {
            if (random.nextBoolean()) {
                System.out.println(nome + " desviou do ataque!");
                desviando = false;
                return;
            } else {
                System.out.println(nome + " falhou ao desviar!");
                desviando = false;
            }
        }

        if (defendendo) {
            dano = dano / 2;
            System.out.println(nome + " defendeu! Dano reduzido para " + dano);
            defendendo = false;
        }

        vidaAtual = vidaAtual - dano;

        if (vidaAtual < 0) {
            vidaAtual = 0;
        }
    }

    void atacar(Personagem p2) {
        int dano = this.ataque - p2.defesa;
        if (dano < 0) {
            dano = 0;
        }
        p2.receberDano(dano);
        System.out.println(this.nome + " atacou " + p2.nome + " deixando o inimigo com " + p2.getVidaAtual() + " de vida");
    }

    void defender() {
        defendendo = true;
        System.out.println(nome + " está em posição de defesa!");
    }

    void desviar() {
        desviando = true;
        System.out.println(this.nome + " tentou desviar");
    }

    public Personagem(String nome, int vidaMaxima, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
    }
}