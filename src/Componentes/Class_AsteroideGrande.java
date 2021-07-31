
package Componentes;

import Demas.Class_Componentes;
import Principal.Panel_Dibujo;
import java.awt.Color;
import java.awt.Dimension;


public class Class_AsteroideGrande extends Class_Componentes{
    
    private Color[][] TX_SELECCIONADO;
    private static Color[][] TX_NORMAL;
    private static Color[][] TX_DESTRUIDO;
    private boolean lanzado;
    
    public Class_AsteroideGrande(int xInicial, int yInicial, int angulo, Dimension limites) {
        super(xInicial, yInicial, angulo, limites, 5, 3, 10, TX_NORMAL.length*Panel_Dibujo.tamañoPIXEL, TX_NORMAL.length*Panel_Dibujo.tamañoPIXEL, 1000); //LIMITE AVACNCE, HP, VEL, TAMAÑOX, TAMAÑOY, PUNTUACION
        TX_SELECCIONADO=TX_NORMAL;
        this.lanzado=false;
    }
    
    //ESTE METODO DEBE SER LLAMADO AL PRINCIPIO DE LA CLASE PRINCIPAL (ANTES DE CREAR ESTOS OBJETOS)
    public static void inicializarTEXTURAS(Color[][] TX_NORMAL,Color[][] TX_DESTRUIDO){
        Class_AsteroideGrande.TX_NORMAL=TX_NORMAL;
        Class_AsteroideGrande.TX_DESTRUIDO=TX_DESTRUIDO;
    }
    
    public Color[][] getTexturaSeleccionado(){
        return TX_SELECCIONADO;
    }
    
    public void AvanzarPRO() {
        this.avanzar();
        if (this.isDestruido()) {
            TX_SELECCIONADO = TX_DESTRUIDO;
            if (!this.lanzado) {
                Panel_Dibujo.agregarAsteroide(new Class_Asteriode(this.getX() + (getXTAMAÑO() / 2), this.getY() + (getYTAMAÑO() / 2), 90, getLimit_Panel()));
                Panel_Dibujo.agregarAsteroide(new Class_Asteriode(this.getX() + (getXTAMAÑO() / 2), this.getY() + (getYTAMAÑO() / 2), 45, getLimit_Panel()));
                Panel_Dibujo.agregarAsteroide(new Class_Asteriode(this.getX() + (getXTAMAÑO() / 2), this.getY() + (getYTAMAÑO() / 2), 125, getLimit_Panel()));
                this.lanzado=true;
            }
        }
    }

}
