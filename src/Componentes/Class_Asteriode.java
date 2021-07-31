
package Componentes;
import Demas.Class_Componentes;
import Principal.Panel_Dibujo;
import java.awt.Color;
import java.awt.Dimension;

public class Class_Asteriode extends Class_Componentes{
    
    private Color[][] TX_SELECCIONADO;
    private static Color[][] TX_NORMAL;
    private static Color[][] TX_DESTRUIDO;
    public Class_Asteriode(int xInicial, int yInicial, int angulo, Dimension limites) {
        super(xInicial, yInicial, angulo, limites, 2, 1, 10, TX_NORMAL.length*Panel_Dibujo.tamañoPIXEL, TX_NORMAL.length*Panel_Dibujo.tamañoPIXEL, 100); //LIMITE AVACNCE, HP, VEL, TAMAÑOX, TAMAÑOY, PUNTUACION
        TX_SELECCIONADO=TX_NORMAL;
    }
    
    //ESTE METODO DEBE SER LLAMADO AL PRINCIPIO DE LA CLASE PRINCIPAL (ANTES DE CREAR ESTOS OBJETOS)
    public static void inicializarTEXTURAS(Color[][] TX_NORMAL,Color[][] TX_DESTRUIDO){
        Class_Asteriode.TX_NORMAL=TX_NORMAL;
        Class_Asteriode.TX_DESTRUIDO=TX_DESTRUIDO;
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