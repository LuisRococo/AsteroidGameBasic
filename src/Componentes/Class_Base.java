
package Componentes;

import java.awt.Color;


public class Class_Base {
    
    //DEBEN INICIALIZARCE DESDE EL PRINCIPIO ESTATICAMENTE
    private static Color[][] TX_NORMAL;
    private static Color[][] TX_DESTRUIDA;
    private static Color[][] TX_ACTUAL;

    public static void inicializarTEXTURAS(Color[][] TX_NORMAL, Color[][] TX_DESTRUIDO) {
        Class_Base.TX_NORMAL = TX_NORMAL;
        Class_Base.TX_DESTRUIDA = TX_DESTRUIDO;
        TX_ACTUAL=Class_Base.TX_NORMAL;
    }
    
    public static void cambiar_TexturaDestruida(){
        TX_ACTUAL=TX_DESTRUIDA;
    }
    
    public static Color[][]getTexturaACTUAL(){
        return TX_ACTUAL;
    } 
}
