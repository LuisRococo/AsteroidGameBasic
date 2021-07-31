
package Principal;

import Componentes.Class_Base;
import java.awt.Dimension;


public class Class_Cañon {
    
    private int angulo;
    private final int largo = 50;
    private final int x_INICIAL;
    private final int y_INICIAL;
    private int x_PUNTA;
    private int y_PUNTA;
    private final int gradosMenos = 10;
    private final int gradosMas = 10;
    private final int AnchoLienzo;
    private final int AlturaLienzo;

    public Class_Cañon(Dimension limites) {
        angulo=90;
        x_PUNTA =0;
        y_PUNTA=0;
        x_INICIAL=(int)limites.width/2-11;
        y_INICIAL=(int)limites.height-7*Class_Base.getTexturaACTUAL()[0].length;
        AnchoLienzo=(int)limites.getWidth();
        AlturaLienzo=(int)limites.getHeight();
        reCalcularPunto();
    }
    
    public void moverIZQ() {
        if (this.angulo + this.gradosMenos <= 180) {
            this.angulo = this.angulo + this.gradosMenos;
            this.reCalcularPunto();
        }
    }

    public void moverDER() {
        if (this.angulo - this.gradosMas >= 0) {
            this.angulo = this.angulo - this.gradosMas;
            this.reCalcularPunto();
        }
    }
    
    private void reCalcularPunto(){
        this.x_PUNTA=(int)(this.largo*Math.cos(Math.toRadians(this.angulo)))+this.getX_INICIAL();
        this.y_PUNTA=this.AlturaLienzo-(int)(this.largo*Math.sin(Math.toRadians(this.angulo)))-7*Class_Base.getTexturaACTUAL()[0].length;
    }
    
    public void disparar(){
        Dimension puntoInicial=new Dimension(this.getX_PUNTA(), this.getY_PUNTA());
        Panel_Dibujo.agregarBala(new Class_Bala(this.AnchoLienzo,this.AlturaLienzo,puntoInicial,this.angulo));
    }

    public int getX_INICIAL() {
        return x_INICIAL;
    }

    public int getY_INICIAL() {
        return y_INICIAL;
    }

    public int getX_PUNTA() {
        return x_PUNTA;
    }

    public int getY_PUNTA() {
        return y_PUNTA;
    }
    
    
}
