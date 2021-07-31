
package Demas;

public class Class_General {

    private final String FILA_ASTEROIDE;
    private final String FILA_ASTERIODE_DESTRUIDO;
    private final String FILA_AVION;
    private final String FILA_AVION_DESTRUIDO;
    private final String FILA_BACKGROUND;
    private final String FILA_BASE;
    private final String FILA_BASE_DESTRUIDA;
    private final String FILA_BACKGROUND_DESTRUIDO;
    private final String FILA_ASTEROIDE_ALMAGEDON;
    private final String FILA_ASTEROIDE_GRANDE;
    private final String FILA_ASTEROIDE_GRANDE_DESTRUIDO;
    public Class_General() {
        FILA_ASTEROIDE = "/Archivos/ASTEROIDE.pnt";
        FILA_ASTERIODE_DESTRUIDO = "/Archivos/ASTEROIDE_DESTRUIDO.pnt";
        FILA_AVION = "/Archivos/AVION.pnt";
        FILA_BACKGROUND = "/Archivos/BACKGROUND2.pnt";
        FILA_BASE = "/Archivos/BASE.pnt";
        FILA_BASE_DESTRUIDA = "/Archivos/BASE_QUEMANDOSE.pnt";
        FILA_BACKGROUND_DESTRUIDO = "/Archivos/BACKGROUND_QUEMANSOSE.pnt";
        FILA_ASTEROIDE_ALMAGEDON = "/Archivos/ASTEROIDE_ALMAGEDON.pnt";
        FILA_ASTEROIDE_GRANDE = "/Archivos/ASTEROIDE_GRANDE.pnt";
        FILA_ASTEROIDE_GRANDE_DESTRUIDO = "/Archivos/ASTEROIDE_GRANDE_DESTRUIDO.pnt";
        FILA_AVION_DESTRUIDO="/Archivos/AVION_DESTRUIDO.pnt";
    }

//    public static final File FILA_ASTEROIDE=new File(getClass().getResource("\\GameAssets\\ASTEROIDE.pnt").toURI());    
    
//    public static final File FILA_ASTEROIDE=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\ASTEROIDE.pnt");
//    public static final File FILA_ASTERIODE_DESTRUIDO=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\ASTEROIDE_DESTRUIDO.pnt");
//    public static final File FILA_AVION=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\AVION.pnt");
//    public static final File FILA_BACKGROUND=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\BACKGROUND2.pnt");
//    public static final File FILA_BASE=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\BASE.pnt");
//    public static final File FILA_BASE_DESTRUIDA=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\BASE_QUEMANDOSE.pnt");
//    public static final File FILA_BACKGROUND_DESTRUIDO=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\BACKGROUND_QUEMANSOSE.pnt");
//    public static final File FILA_ASTEROIDE_ALMAGEDON=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\ASTEROIDE_ALMAGEDON.pnt");
//    public static final File FILA_ASTEROIDE_GRANDE=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\ASTEROIDE_GRANDE.pnt");
//    public static final File FILA_ASTEROIDE_GRANDE_DESTRUIDO=new File("C:\\Users\\Luis Roberto Peña\\Documents\\GameAssets\\ASTEROIDE_GRANDE_DESTRUIDO.pnt");
    
    public static final int MINIMO=1;
    public static final int ALTURA_BASE=8;
    public static final int NUMERO_OBJETOS=2;
    public static final int NUMERO_TEXTURAS=11;
    public static int puntuacionMaxima=0;

    public String getFILA_ASTEROIDE() {
        return FILA_ASTEROIDE;
    }
    public String getFILA_ASTERIODE_DESTRUIDO() {
        return FILA_ASTERIODE_DESTRUIDO;
    }
    public String getFILA_AVION() {
        return FILA_AVION;
    }
    public String getFILA_BACKGROUND() {
        return FILA_BACKGROUND;
    }
    public String getFILA_AVION_DESTRUIDO() {
        return FILA_AVION_DESTRUIDO;
    }
    public String getFILA_BASE() {
        return FILA_BASE;
    }
    public String getFILA_BASE_DESTRUIDA() {
        return FILA_BASE_DESTRUIDA;
    }
    public String getFILA_BACKGROUND_DESTRUIDO() {
        return FILA_BACKGROUND_DESTRUIDO;
    }
    public String getFILA_ASTEROIDE_ALMAGEDON() {
        return FILA_ASTEROIDE_ALMAGEDON;
    }
    public String getFILA_ASTEROIDE_GRANDE() {
        return FILA_ASTEROIDE_GRANDE;
    }
    public String getFILA_ASTEROIDE_GRANDE_DESTRUIDO() {
        return FILA_ASTEROIDE_GRANDE_DESTRUIDO;
    }
    
}
