
package Componentes;

import Principal.Panel_Dibujo;
import java.awt.Color;

public class Class_ASTE_ALMAGEDON {

    private static Color[][]TX_ASTERIDE_ALMAGEDON;
    private final int posX;
    private int posY;
    private final int VEL=2;
    public Class_ASTE_ALMAGEDON(int tamañoLienzoX,int posY) { //PARAMETROS EN RELACION A PIXEL
        this.posX=tamañoLienzoX/2*Panel_Dibujo.tamañoPIXEL-(Class_ASTE_ALMAGEDON.TX_ASTERIDE_ALMAGEDON.length*Panel_Dibujo.tamañoPIXEL/2);
        this.posY=(posY*Panel_Dibujo.tamañoPIXEL);
    }
    
        public static void inicializarTEXTURAS(Color[][] TX_ASTERIDE_ALMAGEDON){
        Class_ASTE_ALMAGEDON.TX_ASTERIDE_ALMAGEDON=TX_ASTERIDE_ALMAGEDON;
    }
    
    public void actualizar_AsteroideAlmagedon(){
        this.posY+=VEL*Panel_Dibujo.tamañoPIXEL;
    }
    
    public Color[][] getTextura(){
        return Class_ASTE_ALMAGEDON.TX_ASTERIDE_ALMAGEDON;
    }


    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    
}
