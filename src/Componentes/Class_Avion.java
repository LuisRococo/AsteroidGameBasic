
package Componentes;
import Demas.Class_Componentes;
import Principal.Panel_Dibujo;
import java.awt.Color;
import java.awt.Dimension;

public class Class_Avion extends Class_Componentes{
    
    private Color[][] TX_SELECCIONADO;
    private static Color[][] TX_NORMAL;
    private static Color[][] TX_DESTRUIDO;
    public Class_Avion(int xInicial, int yInicial, int angulo, Dimension limites) {
        super(xInicial, yInicial, angulo, limites, 1, 1, 10, TX_NORMAL.length*Panel_Dibujo.tamañoPIXEL, TX_NORMAL[0].length*(Panel_Dibujo.tamañoPIXEL),500); //LIMITE AVACNCE, HP, VEL, TAMAÑOX, TAMAÑOY, PUNTUACION
        this.TX_SELECCIONADO=TX_NORMAL;
    }
    
    //ESTE METODO DEBE SER LLAMADO AL PRINCIPIO DE LA CLASE PRINCIPAL (ANTES DE CREAR ESTOS OBJETOS)
    public static void inicializarTEXTURAS(Color[][] TX_NORMAL,Color[][] TX_DESTRUIDO){
        Class_Avion.TX_NORMAL=TX_NORMAL;
        Class_Avion.TX_DESTRUIDO=TX_DESTRUIDO;
    }
    
    public Color[][] getTexturaSeleccionado(){
        return TX_SELECCIONADO;
    }
    
    public void AvanzarPRO(){
        this.avanzar();
        if (this.isDestruido()){
            TX_SELECCIONADO=TX_DESTRUIDO;
        }
    }
}
