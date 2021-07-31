
package Componentes;

import Principal.Panel_Dibujo;
import java.awt.Dimension;


public class Class_SPAWNER {
    
    private int contador;
    private final int LIMITE=180; //NUMERO DE TICK PARA DISPARAR
    private final int X_POS; //METER CON (NUMERO DEL PIXEL * TAMAÑO PIXEL)
    private final int Y_POS;
    private final Dimension TAMAÑOLIENZO;
    private final Dimension LIMITES_GRADOS;
    public Class_SPAWNER(Dimension pos,Dimension tam,Dimension grados){
        this.X_POS=(int)pos.getWidth();
        this.Y_POS=(int)pos.getHeight();
        this.contador=(int)(Math.random()*(this.LIMITE));
        this.TAMAÑOLIENZO=tam;
        this.LIMITES_GRADOS=grados;
    }
    
    public void lanzarObjeto() {
        int aux=this.X_POS;
        int tipoObjeto;
        int grados;
        this.contador++;
        if (contador == this.LIMITE) {
            tipoObjeto = (int) (Math.random() * (101));
            if (tipoObjeto <25) {
                grados=(int)(Math.random()*(this.LIMITES_GRADOS.getHeight()-this.LIMITES_GRADOS.getWidth()+1)+this.LIMITES_GRADOS.getWidth());
                Panel_Dibujo.agregarAsteroiderande(new Class_AsteroideGrande(this.X_POS, this.Y_POS, grados, this.TAMAÑOLIENZO));
            }
            else if (tipoObjeto<40){
                if (this.X_POS<=0){
                    aux=5*Panel_Dibujo.tamañoPIXEL;
                }
                else if (this.X_POS==TAMAÑOLIENZO.getWidth()){
                    aux=90*Panel_Dibujo.tamañoPIXEL;
                }
                Panel_Dibujo.agregarAvion(new Class_Avion(aux, this.Y_POS, 90, this.TAMAÑOLIENZO));
            }
            else if (tipoObjeto <=100){
                grados=(int)(Math.random()*(this.LIMITES_GRADOS.getHeight()-this.LIMITES_GRADOS.getWidth()+1)+this.LIMITES_GRADOS.getWidth());
                Panel_Dibujo.agregarAsteroide(new Class_Asteriode(this.X_POS, this.Y_POS, grados, this.TAMAÑOLIENZO));
            }
            this.contador=(int)(Math.random()*(this.LIMITE));
        }
    }
    
}
