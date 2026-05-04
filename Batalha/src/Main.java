import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int opcao;

        Personagem p1 = new Personagem("Guerreiro", 100, 20, 5);
        Personagem p2 = new Personagem("Orc", 100, 16, 8);

        System.out.println("---------------Bem vindo ao novo Sistema de Batalha--------------- Feito por: Rodrigo Beierstdt :)");
        Scanner sc = new Scanner(System.in);

        System.out.println("Você é o Guerreiro que irá trazer paz ao mundo!");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Seu inimigo é um feroz ORC que quer destruir o planeta!");
        TimeUnit.SECONDS.sleep(1);

        while (p1.estaVivo() && p2.estaVivo()) {

            do {
                System.out.println("Escolha uma opção:\n1- Atacar\n2- Defender\n3- Desviar (chance de erro)");

                try {
                    opcao = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Digite um número.");
                    sc.nextLine();
                    opcao = 0;
                    continue;
                }

                switch (opcao) {
                    case 1:
                        p1.atacar(p2);
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println();
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    case 2:
                        p1.defender();
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    case 3:
                        p1.desviar();
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }

            } while (opcao < 1 || opcao > 3);

            if (p2.estaVivo()) {
                int acaoOrc = new Random().nextInt(3);
                switch (acaoOrc) {
                    case 0:
                        System.out.println("Orc decidiu ATACAR!");
                        TimeUnit.SECONDS.sleep(1);
                        p2.atacar(p1);
                        break;
                    case 1:
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Orc decidiu DEFENDER!");
                        TimeUnit.SECONDS.sleep(1);
                        p2.defender();
                        break;
                    case 2:
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Orc tentou DESVIAR!");
                        TimeUnit.SECONDS.sleep(1);
                        p2.desviar();
                        break;
                }
            }

            System.out.println();
        }

        if (p1.estaVivo()) {
            System.out.println("O Guerreiro venceu!");
        } else {
            System.out.println("O Orc venceu!");
        }

        sc.close();
    }
}