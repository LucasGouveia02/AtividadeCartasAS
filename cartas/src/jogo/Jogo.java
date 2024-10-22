package jogo;

import java.util.ArrayList;
import java.util.List;

import classes.CartaCarro;
import classes.Jogador;
import factory.FactoryCarta;

public class Jogo {

    private Jogador j1;
    private Jogador j2;

    List<CartaCarro> todosOsCarros;

    public Jogo() {
        j1 = new Jogador();
        j2 = new Jogador();
        criarTodosCarros(2);
    }

    public void compararCartas(CartaCarro c1, CartaCarro c2, int atributo) {
        switch (atributo) {
            case 0:
                if (c1.getVelocidade() > c2.getVelocidade()) {
                    j2.getCartasEscolhidas().remove(c2);
                } else if(c1.getVelocidade() < c2.getVelocidade()) {
                    j1.getCartasEscolhidas().remove(c1);
                }
                break;
            case 1:
                if (c1.getAceleracao() > c2.getAceleracao()) {
                    j2.getCartasEscolhidas().remove(c2);
                } else if(c1.getAceleracao() < c2.getAceleracao()) {
                    j1.getCartasEscolhidas().remove(c1);
                }
                break;
            case 2:
                if (c1.getFreio() > c2.getFreio()) {
                    j2.getCartasEscolhidas().remove(c2);
                } else if(c1.getFreio() < c2.getFreio()) {
                    j1.getCartasEscolhidas().remove(c1);
                }
                break;
            case 3:
                if (c1.getTurbo() > c2.getTurbo()) {
                    j2.getCartasEscolhidas().remove(c2);
                } else if(c1.getTurbo() < c2.getTurbo()) {
                    j1.getCartasEscolhidas().remove(c1);
                }
                break;
            default:
                break;
        }
    }

    public void escolherCartas(int jogador, int indexCarta) {
        if (jogador == 1) {
            j1.getCartasEscolhidas().add(FactoryCarta.fabricarCarro(indexCarta));
        } else if(jogador == 2) {
            j2.getCartasEscolhidas().add(FactoryCarta.fabricarCarro(indexCarta));
        }
        
    }

    public List<CartaCarro> criarTodosCarros(int tamLista) {
        todosOsCarros = new ArrayList<>();

        if (todosOsCarros.isEmpty()) {
            for (int i = 0; i < tamLista; i++) {
                todosOsCarros.add(FactoryCarta.fabricarCarro(i));
            }
        }

        return todosOsCarros;
    }

    public void usarPowerUP(int jogador, int powerUP, int indexCarta) {
        if (jogador == 1) {
            switch (powerUP) {
                case 1:
                    j1.aumentarPontoStatus();
                    break;
                case 2:
                    j1.adicionarCartaDeck(indexCarta);
                    break;
                case 3:
                    j1.maximoPontoCarta(indexCarta);
                    break;
                case 4:
                    j2.descartar(indexCarta);
                    j1.getPowerUPs().remove("4 - DESCARTAR");
                    break;
                default:
                    break;
            }
        } else if(jogador == 2) {
            switch (powerUP) {
                case 1:
                    j2.aumentarPontoStatus();
                    break;
                case 2:
                    j2.adicionarCartaDeck(indexCarta);
                    break;
                case 3:
                    j2.maximoPontoCarta(indexCarta);
                    break;
                case 4:
                    j1.descartar(indexCarta);
                    j2.getPowerUPs().remove("4 - DESCARTAR");
                    break;
                default:
                    break;
            }
        }
    }

    public List<CartaCarro> getTodosOsCarros() {
        return todosOsCarros;
    }

    public Jogador getJ1() {
        return j1;
    }

    public Jogador getJ2() {
        return j2;
    }

    
}
