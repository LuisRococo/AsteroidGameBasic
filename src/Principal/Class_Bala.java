
package Principal;

import java.awt.Dimension;


public class Class_Bala {
    
    double h;
    boolean activo;
    private int x;
    private int y;
    private final int LIMITX;
    private final int LIMITY;
    private final double ANGULO;
    private final int VELOCIDAD=20;
    private final int posInicialX;
    private final int posInicialY;
    private final static int TAMAÑOX=7;
    private final static int TAMAÑOY=7; 


    public Class_Bala(int limitX,int limitY, Dimension pos,double angulo){
        this.LIMITX=limitX;
        this.LIMITY=limitY;
        this.posInicialX=(int)pos.getWidth()-(TAMAÑOX/2);
        this.posInicialY=(int)pos.getHeight()-(TAMAÑOY/2);
        this.ANGULO = angulo;
        this.h = 0;
        this.activo = true;
        this.x = this.posInicialX;
        this.y = this.posInicialY;
    }

    public void actAvance(){
        h=h+this.VELOCIDAD;
        int Xaux=this.posInicialX;
        int Yaux=this.posInicialY;
        Xaux=Xaux+(int)(h*Math.cos(Math.toRadians(this.ANGULO)));
        Yaux=Yaux-(int)(h*Math.sin(Math.toRadians(this.ANGULO)));
        this.x=Xaux;
        this.y=Yaux;
        if (Xaux>this.LIMITX||Yaux>this.LIMITY||Xaux+getTAMAÑOX()<0||Yaux+getTAMAÑOY()<0){
            this.activo=false;
        }
    }
    
    public boolean getActivo(){
        return this.activo;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public static int getTAMAÑOX() {
        return TAMAÑOX;
    }
    public static int getTAMAÑOY() {
        return TAMAÑOY;
    }
}
