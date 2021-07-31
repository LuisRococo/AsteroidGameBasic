
package Principal;
import Componentes.*;
import Demas.Class_General;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Panel_Dibujo extends JPanel{

    private int contador;
    public static int tamañoPIXEL;
    private int puntuacion;
    private static Color[][] TX_BACKGROUND;
    private static Color[][] base_LIENZO;
    private final Class_Cañon cañon;
    private boolean gameOver;
    private boolean almagedon;
    private boolean flash;
    private static ArrayList <Class_Bala> arregloBalas;
    private static ArrayList <Class_Asteriode> arregloAsteroides;
    private static ArrayList <Class_AsteroideGrande> arregloAsteroidesG;
    private static ArrayList <Class_Avion> arregloAviones;
    private final Class_SPAWNER lanzador1;
    private final Class_SPAWNER lanzador2;
    private final Class_SPAWNER lanzador3;
    private final Class_ASTE_ALMAGEDON asteroideAlmagedon;
    public Panel_Dibujo(Dimension tamañoPanel,Class_Cañon cañon) {
        this.setSize(tamañoPanel);
        this.setPreferredSize(tamañoPanel);
        Panel_Dibujo.base_LIENZO=new Color[Panel_Dibujo.TX_BACKGROUND.length][Panel_Dibujo.TX_BACKGROUND[0].length];
        Panel_Dibujo.arregloBalas=new ArrayList<>();
        Panel_Dibujo.arregloAsteroides=new ArrayList<>();
        Panel_Dibujo.arregloAsteroidesG=new ArrayList<>();
        Panel_Dibujo.arregloAviones=new ArrayList<>();
        inicializar((int)tamañoPanel.getWidth(), (int)tamañoPanel.getHeight());
        this.asteroideAlmagedon=new Class_ASTE_ALMAGEDON(base_LIENZO.length, -10);
        this.cañon=cañon;
        this.gameOver=false;
        this.puntuacion=0;
        this.almagedon=false;
        this.flash=false;
        this.contador=0;
        lanzador1=new Class_SPAWNER(new Dimension(0, 0), this.getSize(), new Dimension(90, 135));
        lanzador2=new Class_SPAWNER(new Dimension(this.getWidth()/2, 0), this.getSize(), new Dimension(60, 120));
        lanzador3=new Class_SPAWNER(new Dimension(this.getWidth(), 0), this.getSize(), new Dimension(45, 90));
    }
    
    public static Dimension getTamañoPixeles(){
        return new Dimension(Panel_Dibujo.base_LIENZO.length, Panel_Dibujo.base_LIENZO[0].length);
    }
    
    private void inicializar(int w,int h){
        int maximo=(w>h)? w:h;
        Panel_Dibujo.tamañoPIXEL=maximo/Panel_Dibujo.base_LIENZO.length;
        this.repaint();
    }
    
    public static void setTexturaPrincipale(Color[][]BACKGROUND){
        Panel_Dibujo.TX_BACKGROUND=BACKGROUND;
    }
    public void setTexturaGameOver(Color[][] backGround_Almagedon){
        Panel_Dibujo.TX_BACKGROUND=backGround_Almagedon;
    }
    public void setAlmagedonOn(){
        this.almagedon=true;
    }
    
    public void actualizarLanzadores(){
        lanzador1.lanzarObjeto();
        lanzador2.lanzarObjeto();
        lanzador3.lanzarObjeto();
    }
    
    public static void agregarBala(Class_Bala nueva){
        arregloBalas.add(nueva);
    }
    public static void agregarAsteroide(Class_Asteriode nuevo){
        arregloAsteroides.add(nuevo);
    }
    public static void agregarAsteroiderande(Class_AsteroideGrande nuevo){
        arregloAsteroidesG.add(nuevo);
    }
    public static void agregarAvion(Class_Avion nuevo){
        arregloAviones.add(nuevo);
    }
    
    public int getPuntuacion(){
        return this.puntuacion;
    }
    public boolean isGameOver(){
        return this.gameOver;
    }
    
    public void actualizarBalas(){
        for (int i=0;i<arregloBalas.size();i++){
            arregloBalas.get(i).actAvance(); //...if null?
            if (!arregloBalas.get(i).getActivo()){
                arregloBalas.remove(i);
                i--;
            }
        }
    }
    public void actualizarAsteroides(){
        for (int i=0;i<arregloAsteroides.size();i++){
            arregloAsteroides.get(i).AvanzarPRO();
            if (!arregloAsteroides.get(i).isActivo()){
                arregloAsteroides.remove(i);
                i--;
            }
            else{
                isGameOver(arregloAsteroides.get(i).getY(),arregloAsteroides.get(i).getYTAMAÑO());
            }
        }
    }
    public void actualizarAsteroidesG(){
        for (int i=0;i<arregloAsteroidesG.size();i++){
            arregloAsteroidesG.get(i).AvanzarPRO();
            if (!arregloAsteroidesG.get(i).isActivo()){
                arregloAsteroidesG.remove(i);
                i--;
            }
            else{
                isGameOver(arregloAsteroidesG.get(i).getY(),arregloAsteroidesG.get(i).getYTAMAÑO());
            }
        }
    }
    public void actualizarAviones(){
        for (int i=0;i<arregloAviones.size();i++){
            arregloAviones.get(i).AvanzarPRO();
            if (!arregloAviones.get(i).isActivo()){
                arregloAviones.remove(i);
                i--;
            }
            else{
                isGameOver(arregloAviones.get(i).getY(),arregloAviones.get(i).getYTAMAÑO());
            }
        }
    }
    public boolean actualizarGameOver(){
        if (contador<2){
            this.flash=true;
            contador++;
        }
        else if (contador>=12){
            return true;
        }
        else if (contador>=10){
            this.flash=true;
            contador++;
        }
        else if(contador>=2){
            this.flash=false;
            asteroideAlmagedon.actualizar_AsteroideAlmagedon();
            contador++;
        }
        return false;
    }
    private void isGameOver(int y,int tamaño){
        if (y+tamaño>this.getHeight()-Class_General.ALTURA_BASE*tamañoPIXEL) this.gameOver=true;
    }
    public void gameOverLimpiarTodo(){
        arregloAsteroides=new ArrayList<>();
        arregloAsteroidesG=new ArrayList<>();
        arregloBalas=new ArrayList<>();
    }
    public void detectarImpacto(){
        Class_Bala auxBala;
        Class_Asteriode auxAste;
        Class_Avion auxAvio;
        Class_AsteroideGrande auxAsteG;
        boolean xBalaObj1;
        boolean xBalaObj2;
        boolean yBalaObj1;
        boolean yBalaObj2;
        for (int i = 0; i < arregloBalas.size(); i++) {
            auxBala = arregloBalas.get(i);
            for (int y = 0; y < arregloAsteroides.size(); y++) {
                auxAste = arregloAsteroides.get(y);
                if (!auxAste.isDestruido()) {
                    xBalaObj1 = (auxBala.getX() >= auxAste.getX() || auxBala.getX() + Class_Bala.getTAMAÑOX() >= auxAste.getX());
                    xBalaObj2 = (auxBala.getX() <= auxAste.getX() + auxAste.getXTAMAÑO() || auxBala.getX() + Class_Bala.getTAMAÑOX() <= auxAste.getX() + auxAste.getXTAMAÑO());
                    yBalaObj1 = (auxBala.getY() >= auxAste.getY() || auxBala.getY() + Class_Bala.getTAMAÑOY() >= auxAste.getY());
                    yBalaObj2 = (auxBala.getY() <= auxAste.getY() + auxAste.getYTAMAÑO() || auxBala.getY() + Class_Bala.getTAMAÑOY() <= auxAste.getY() + auxAste.getYTAMAÑO());
                    if (xBalaObj1 && xBalaObj2 && yBalaObj1 && yBalaObj2) {
                        auxAste.disparado();
                        if (auxAste.isDestruido()) this.puntuacion += auxAste.getPuntuacion();
                        auxBala.activo = false;
                    }
                }
            }
        }
        for (int i = 0; i < arregloBalas.size(); i++) {
            auxBala = arregloBalas.get(i);
            for (int y = 0; y < arregloAsteroidesG.size(); y++) {
                auxAsteG = arregloAsteroidesG.get(y);
                if (!auxAsteG.isDestruido()) {
                    xBalaObj1 = (auxBala.getX() >= auxAsteG.getX() || auxBala.getX() + Class_Bala.getTAMAÑOX() >= auxAsteG.getX());
                    xBalaObj2 = (auxBala.getX() <= auxAsteG.getX() + auxAsteG.getXTAMAÑO() || auxBala.getX() + Class_Bala.getTAMAÑOX() <= auxAsteG.getX() + auxAsteG.getXTAMAÑO());
                    yBalaObj1 = (auxBala.getY() >= auxAsteG.getY() || auxBala.getY() + Class_Bala.getTAMAÑOY() >= auxAsteG.getY());
                    yBalaObj2 = (auxBala.getY() <= auxAsteG.getY() + auxAsteG.getYTAMAÑO() || auxBala.getY() + Class_Bala.getTAMAÑOY() <= auxAsteG.getY() + auxAsteG.getYTAMAÑO());
                    if (xBalaObj1 && xBalaObj2 && yBalaObj1 && yBalaObj2) {
                        auxAsteG.disparado();
                        if (auxAsteG.isDestruido()) this.puntuacion += auxAsteG.getPuntuacion();
                        auxBala.activo = false;
                    }
                }
            }
        }
        for (int i = 0; i < arregloBalas.size(); i++) {
            auxBala = arregloBalas.get(i);
            for (int y = 0; y < arregloAviones.size(); y++) {
                auxAvio = arregloAviones.get(y);
                if (!auxAvio.isDestruido()) {
                    xBalaObj1 = (auxBala.getX() >= auxAvio.getX() || auxBala.getX() + Class_Bala.getTAMAÑOX() >= auxAvio.getX());
                    xBalaObj2 = (auxBala.getX() <= auxAvio.getX() + auxAvio.getXTAMAÑO() || auxBala.getX() + Class_Bala.getTAMAÑOX() <= auxAvio.getX() + auxAvio.getXTAMAÑO());
                    yBalaObj1 = (auxBala.getY() >= auxAvio.getY() || auxBala.getY() + Class_Bala.getTAMAÑOY() >= auxAvio.getY());
                    yBalaObj2 = (auxBala.getY() <= auxAvio.getY() + auxAvio.getYTAMAÑO() || auxBala.getY() + Class_Bala.getTAMAÑOY() <= auxAvio.getY() + auxAvio.getYTAMAÑO());
                    if (xBalaObj1 && xBalaObj2 && yBalaObj1 && yBalaObj2) {
                        auxAvio.disparado();
                        if (auxAvio.isDestruido()) this.puntuacion += auxAvio.getPuntuacion();
                        auxBala.activo = false;
                    }
                }
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int aux;
        int auxX;
        int auxY;
        Color arrColor[][];
        base_LIENZO=TX_BACKGROUND;
        
        if (!this.flash) {
            //AGREGAR BACKGROUND
            Panel_Dibujo.base_LIENZO = Panel_Dibujo.TX_BACKGROUND;
            //AGREGAR BASE
            arrColor = Class_Base.getTexturaACTUAL();
            aux = Panel_Dibujo.base_LIENZO[0].length - arrColor[0].length;
            for (int y = 0; y < arrColor[0].length; y++) {
                for (int x = 0; x < arrColor.length; x++) {
                    if (arrColor[x][y] != null) {
                        Panel_Dibujo.base_LIENZO[x][aux] = arrColor[x][y];
                    }
                }
                aux++;
            }
            //PINTAR LIENZO
            for (int y = 0; y < Panel_Dibujo.base_LIENZO[0].length; y++) {
                for (int x = 0; x < Panel_Dibujo.base_LIENZO.length; x++) {
                    if (Panel_Dibujo.base_LIENZO[x][y] != null) {
                        g.setColor(Panel_Dibujo.base_LIENZO[x][y]);
                        g.fillRect(x * Panel_Dibujo.tamañoPIXEL, y * Panel_Dibujo.tamañoPIXEL, Panel_Dibujo.tamañoPIXEL, Panel_Dibujo.tamañoPIXEL);
                    }
                }
            }
            if (!this.almagedon) {
                //PINTAR CAÑON
                g.setColor(Color.white);
                g.drawLine(cañon.getX_INICIAL(), cañon.getY_INICIAL(), cañon.getX_PUNTA(), cañon.getY_PUNTA());
                //PINTAR BALAS
                g.setColor(Color.ORANGE);
                for (int i = 0; i < arregloBalas.size(); i++) {
                    g.fillRect(arregloBalas.get(i).getX(), arregloBalas.get(i).getY(), Class_Bala.getTAMAÑOX(), Class_Bala.getTAMAÑOY());
                }
                //PINTAR ASTEROIDES
                for (int i = 0; i < arregloAsteroides.size(); i++) {
                    arrColor = arregloAsteroides.get(i).getTexturaSeleccionado();
                    auxX = arregloAsteroides.get(i).getX();
                    auxY = arregloAsteroides.get(i).getY();
                    for (int y = 0; y < arrColor[0].length; y++) {
                        for (int x = 0; x < arrColor.length; x++) {
                            if (arrColor[x][y] != null) {
                                g.setColor(arrColor[x][y]);
                                g.fillRect(auxX, auxY, Panel_Dibujo.tamañoPIXEL, Panel_Dibujo.tamañoPIXEL);
                            }
                            auxX += Panel_Dibujo.tamañoPIXEL;
                        }
                        auxX = arregloAsteroides.get(i).getX();
                        auxY += Panel_Dibujo.tamañoPIXEL;
                    }
                }
                //PINTAR ASTEROIDES GRANDES
                for (int i = 0; i < arregloAsteroidesG.size(); i++) {
                    arrColor = arregloAsteroidesG.get(i).getTexturaSeleccionado();
                    auxX = arregloAsteroidesG.get(i).getX();
                    auxY = arregloAsteroidesG.get(i).getY();
                    for (int y = 0; y < arrColor[0].length; y++) {
                        for (int x = 0; x < arrColor.length; x++) {
                            if (arrColor[x][y] != null) {
                                g.setColor(arrColor[x][y]);
                                g.fillRect(auxX, auxY, Panel_Dibujo.tamañoPIXEL, Panel_Dibujo.tamañoPIXEL);
                            }
                            auxX += Panel_Dibujo.tamañoPIXEL;
                        }
                        auxX = arregloAsteroidesG.get(i).getX();
                        auxY += Panel_Dibujo.tamañoPIXEL;
                    }
                }
                //PINTAR AVIONES
                for (int i = 0; i < arregloAviones.size(); i++) {
                    arrColor = arregloAviones.get(i).getTexturaSeleccionado();
                    auxX = arregloAviones.get(i).getX();
                    auxY = arregloAviones.get(i).getY();
                    for (int y = 0; y < arrColor[0].length; y++) {
                        for (int x = 0; x < arrColor.length; x++) {
                            if (arrColor[x][y] != null) {
                                g.setColor(arrColor[x][y]);
                                g.fillRect(auxX, auxY, Panel_Dibujo.tamañoPIXEL, Panel_Dibujo.tamañoPIXEL);
                            }
                            auxX += Panel_Dibujo.tamañoPIXEL;
                        }
                        auxX = arregloAviones.get(i).getX();
                        auxY += Panel_Dibujo.tamañoPIXEL;
                    }
                }
            } else {
                //PINTAR ASTEROIDE ALMAGEDON
                arrColor=asteroideAlmagedon.getTextura();
                auxX=asteroideAlmagedon.getPosX();
                auxY=asteroideAlmagedon.getPosY();
                for (int y = 0; y < arrColor[0].length; y++) {
                    for (int x = 0; x < arrColor.length; x++) {
                        if (arrColor[x][y] != null) {
                            g.setColor(arrColor[x][y]);
                            g.fillRect(auxX, auxY, tamañoPIXEL, tamañoPIXEL);
                        }
                        auxX += tamañoPIXEL;
                    }
                    auxX = asteroideAlmagedon.getPosX();
                    auxY+=tamañoPIXEL;
                }
            }

        } else {
            this.setBackground(Color.WHITE);
        }

    }
}
