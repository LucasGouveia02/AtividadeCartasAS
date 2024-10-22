package factory;

import carros.Kicks;
import carros.Kwid;
import classes.CartaCarro;

public class FactoryCarta {
    
    public static CartaCarro fabricarCarro(int escolha) {
        switch (escolha) {
            case 0:
                return new Kwid();
            case 1:
                return new Kicks();
            default:
                return null;
        }
    }
}
