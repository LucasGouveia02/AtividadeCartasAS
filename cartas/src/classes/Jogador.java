package classes;

import java.util.ArrayList;
import java.util.List;

import factory.FactoryCarta;
import powerUPs.PowerUps;

public class Jogador implements PowerUps {
    
    private List<String> powerUPs;
    private List<CartaCarro> cartasEscolhidas;
    

    public Jogador() {
        cartasEscolhidas = new ArrayList<>();
        powerUPs = new ArrayList<>(List.of("1 - AUMENTAR_PONTO_STATUS", "2 - ADICIONAR_CARTA_DECK","3 - MAXIMO_PONTO_CARTA", "4 - DESCARTAR"));
    }

    public Jogador(List<CartaCarro> cartasEscolhidas) {
        this.cartasEscolhidas = cartasEscolhidas;
    }

    public List<CartaCarro> getCartasEscolhidas() {
        return cartasEscolhidas;
    }
    

    public void setCartasEscolhidas(List<CartaCarro> cartasEscolhidas) {
        this.cartasEscolhidas = cartasEscolhidas;
    }

    @Override
    public void aumentarPontoStatus() {
        for (CartaCarro cartaCarro : cartasEscolhidas) {
            cartaCarro.setAceleracao(cartaCarro.getAceleracao() + 1);
            cartaCarro.setFreio(cartaCarro.getFreio() + 1);
            cartaCarro.setTurbo(cartaCarro.getTurbo() + 1);
            cartaCarro.setVelocidade(cartaCarro.getVelocidade() + 1);
        }
        powerUPs.remove("1 - AUMENTAR_PONTO_STATUS");
    }

    @Override
    public void adicionarCartaDeck(int indexCarta) {
        cartasEscolhidas.add(FactoryCarta.fabricarCarro(indexCarta));
        powerUPs.remove("2 - ADICIONAR_CARTA_DECK");
    }

    @Override
    public void maximoPontoCarta(int indexCarta) {
       cartasEscolhidas.get(indexCarta).setAceleracao(100);
       cartasEscolhidas.get(indexCarta).setFreio(100);
       cartasEscolhidas.get(indexCarta).setTurbo(100);
       cartasEscolhidas.get(indexCarta).setVelocidade(100);
       powerUPs.remove("3 - MAXIMO_PONTO_CARTA");
    }

    @Override
    public void descartar(int indexCarta) {
        cartasEscolhidas.remove(indexCarta);
    }

    public List<String> getPowerUPs() {
        return powerUPs;
    }
}
