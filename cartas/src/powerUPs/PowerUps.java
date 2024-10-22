package powerUPs;

import java.util.List;

import classes.CartaCarro;
import classes.Jogador;
import jogo.Jogo;

public interface PowerUps {


    public void aumentarPontoStatus();
    public void adicionarCartaDeck(int indexCarta);
    public void maximoPontoCarta(int indexCarta);
    public void descartar(int indexCarta);



    // AUMENTAR_PONTO{
    //     @Override
    //     void carrosPowerUps(Jogador jogador){
    //         for (CartaCarro cartaCarro : jogador.getCartasEscolhidas()) {
    //             cartaCarro.setAceleracao(cartaCarro.getAceleracao() + 1);
    //             cartaCarro.setFreio(cartaCarro.getFreio() + 1);
    //             cartaCarro.setTurbo(cartaCarro.getTurbo() + 1);
    //             cartaCarro.setVelocidade(cartaCarro.getVelocidade() + 1);
    //         }
    //     }
           
        
    // }, 
    // ADICIONAR_CARTA_DECK{

    //     @Override
    //     void carrosPowerUps(Jogador jogador){
            
    //     }
        
        
    // }


    // abstract void carrosPowerUps(Jogador jogador);


}
