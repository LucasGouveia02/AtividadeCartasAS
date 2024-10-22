import classes.CartaCarro;
import classes.Jogador;
import jogo.Jogo;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Random numAleatorio = new Random();

        Jogo jogo = new Jogo();

        int count = 0;
        for (CartaCarro carro : jogo.getTodosOsCarros()) {
            System.out.println(count++ + " - " + carro.getNome() + "|" + carro.getVelocidade() + "|"
                    + carro.getAceleracao() + "|" + carro.getFreio() + "|" + carro.getTurbo());
        }

        System.out.println("Jogador 1 escolha suas cartas: ");
        for (int i = 0; i < 6; i++) {
            System.out.println("Escolha o indice do carro " + i + ": ");
            int escolha = entrada.nextInt();

            jogo.escolherCartas(1, escolha);
        }

        System.out.println("Jogador 2 escolha suas cartas: ");
        for (int i = 0; i < 6; i++) {
            System.out.println("Escolha o indice do carro " + i + ": ");
            int escolha = entrada.nextInt();

            jogo.escolherCartas(2, escolha);
        }

        while (jogo.getJ1().getCartasEscolhidas().size() > 0 && jogo.getJ2().getCartasEscolhidas().size() > 0) {

            System.out.println("Jogador 1: ");
            System.out.println("Escolha sua carta para o turno: ");

            count = 0;
            for (CartaCarro carro : jogo.getJ1().getCartasEscolhidas()) {
                System.out.println(count++ + " - " + carro.getNome() + "|" + carro.getVelocidade() + "|"
                        + carro.getAceleracao() + "|" + carro.getFreio() + "|" + carro.getTurbo());
            }

            int escolhaCarta1 = entrada.nextInt();

            if (jogo.getJ2().getPowerUPs().size() > 0) {
                System.out.println("Jogador 1: ");
                System.out.println("Deseja usar um powerUP nessa rodada? (1 - sim | 0 - não)");
                int escolhaPowerUP = entrada.nextInt();

                if (escolhaPowerUP == 1) {
                    System.out.println("Escolha o powerUP:");
                    for (String powerUp : jogo.getJ1().getPowerUPs()) {
                        System.out.println(powerUp);
                    }

                    int escolhaPowerUPIndex = entrada.nextInt();
                    if (escolhaPowerUPIndex > 1 && escolhaPowerUPIndex <= 4) {
                        System.out.println("Escolha o indice da carta: ");
                        int indexCarta = entrada.nextInt();
                        jogo.usarPowerUP(1, escolhaPowerUPIndex, indexCarta);
                    } else if (escolhaPowerUPIndex == 1) {
                        jogo.usarPowerUP(1, escolhaPowerUPIndex, 0);
                    } else {
                        System.out.println("Número inválido!");
                    }
                }
            }

            System.out.println("Jogador 2: ");
            System.out.println("Escolha sua carta para o turno: ");

            count = 0;
            for (CartaCarro carro : jogo.getJ2().getCartasEscolhidas()) {
                System.out.println(count++ + " - " + carro.getNome() + "|" + carro.getVelocidade() + "|"
                        + carro.getAceleracao() + "|" + carro.getFreio() + "|" + carro.getTurbo());
            }

            int escolhaCarta2 = entrada.nextInt();

            if (jogo.getJ2().getPowerUPs().size() > 0) {
                System.out.println("Jogador 2: ");
                System.out.println("Deseja usar um powerUP nessa rodada? (1 - sim | 0 - não)");
                int escolhaPowerUP2 = entrada.nextInt();

                if (escolhaPowerUP2 == 1) {
                    System.out.println("Escolha o powerUP:");
                    for (String powerUp : jogo.getJ2().getPowerUPs()) {
                        System.out.println(powerUp);
                    }

                    int escolhaPowerUPIndex = entrada.nextInt();
                    if (escolhaPowerUPIndex > 1 && escolhaPowerUPIndex <= 4) {
                        System.out.println("Escolha o indice da carta: ");
                        int indexCarta = entrada.nextInt();
                        jogo.usarPowerUP(2, escolhaPowerUPIndex, indexCarta);
                    } else if (escolhaPowerUPIndex == 1) {
                        jogo.usarPowerUP(2, escolhaPowerUPIndex, 0);
                    } else {
                        System.out.println("Número inválido!");
                    }
                }
            }

            int num = numAleatorio.nextInt(2);

            if (num == 0) {
                System.out.println("Jogador 1 escolha o atributo");
            } else {
                System.out.println("Jogador 2 escolha o atributo");
            }

            int escolhaAtributo = entrada.nextInt();
            jogo.compararCartas(jogo.getJ1().getCartasEscolhidas().get(escolhaCarta1),
                    jogo.getJ2().getCartasEscolhidas().get(escolhaCarta2), escolhaAtributo);

            if (jogo.getJ1().getCartasEscolhidas().size() <= 0) {
                System.out.println("Jogador 2 venceu!");
                break;
            } else if (jogo.getJ2().getCartasEscolhidas().size() <= 0) {
                System.out.println("Jogador 1 venceu!");
                break;
            }
        }
    }
}
