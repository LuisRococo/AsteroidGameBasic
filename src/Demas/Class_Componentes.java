
package Demas;

import java.awt.Dimension;


public class Class_Componentes {
    
    private final int VELOCIDAD;
    private final int XINICIAL;
    private final int YINICIAL;
    private final int ANGULO;
    private final int LIMIT_AVANCE;
    private static Dimension LIMIT_PANEL;
    private boolean activo;
    private boolean destruido;
    private int cont_Avance;
    private int HP;
    private int x;
    private int y;
    private int h;
    private final int XTAMAÑO;
    private final int YTAMAÑO;
    private final int PUNTUACION;
    
    public Class_Componentes (int xInicial,int yInicial, int angulo,Dimension limites, int limit_Avance,int hp,int velocidad,int Xtamaño,int Ytamaño,int puntuacion){
        //PUNTO DE REFERENCIA - EZQUINA SUPERIOR INZQUIERDA)
        this.XINICIAL=xInicial-(Xtamaño/2); //QUE SE INICIALIZE CENTRADO AL SPAWNEAR
        this.YINICIAL=yInicial;
        this.x=XINICIAL;
        this.y=YINICIAL;
        this.ANGULO=angulo;
        LIMIT_PANEL=limites;
        this.LIMIT_AVANCE=limit_Avance;
        this.VELOCIDAD=velocidad;
        this.h=0;
        this.activo=true;
        this.destruido=false;
        this.HP=hp;
        XTAMAÑO=Xtamaño;
        YTAMAÑO=Ytamaño;
        this.cont_Avance=0;
        this.PUNTUACION=puntuacion;
    }
    
    public void avanzar(){
        if (this.isDestruido()) {
            if (this.cont_Avance == this.LIMIT_AVANCE) {
                this.activo = false;
            }
            else cont_Avance++;
        } else {
            if (LIMIT_AVANCE == cont_Avance) {
                h = h + this.VELOCIDAD;
                this.x = this.XINICIAL - (int) (h * Math.cos(Math.toRadians(this.ANGULO)));
                this.y = this.YINICIAL + (int) (h * Math.sin(Math.toRadians(this.ANGULO)));
                this.cont_Avance = 0;

                if (this.XTAMAÑO + this.x <= 0 || this.x > Class_Componentes.LIMIT_PANEL.getWidth()) {
                    this.activo = false;
                }
                if (this.y > Class_Componentes.LIMIT_PANEL.getHeight() || this.YTAMAÑO + this.y <= 0) {
                    this.activo = false;
                }
            }
            else cont_Avance++;
        }
    }
    
    public boolean disparado(){ //REGRESA TRUE SI HA SIDO DESTRUIDO
        HP=HP-1;
        if (HP==0) {
            this.destruido=true;
            this.cont_Avance=0;
            return true;
        }
        else return false;
    }

    public boolean isActivo() {
        return activo;
    }
    public boolean isDestruido() {
        return destruido;
    }
    public int getHp() {
        return HP;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getPuntuacion(){
        return PUNTUACION;
    }
    public static Dimension getLimit_Panel(){
        return LIMIT_PANEL;
    }

    public int getXTAMAÑO() {
        return XTAMAÑO;
    }
    public int getYTAMAÑO() {
        return YTAMAÑO;
    }
    
}
