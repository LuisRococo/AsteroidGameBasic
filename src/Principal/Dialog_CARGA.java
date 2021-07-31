/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Demas.Class_General;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Dialog_CARGA extends javax.swing.JDialog {

    private Timer timer;
    private TimerTask task;
    private final int esperar=100;

    private Color Asteriode[][];
    private Color Asteriode_Destruido[][];
    private Color BackGround[][];
    private Color Base[][];
    private Color Avion[][];
    private Color AvionDestruido[][];
    private Color BackGround_Destruido[][];
    private Color Base_Destruida[][];
    private Color asteroide_Almagedon[][];
    private Color AsteroideGrande[][];
    private Color AsteroideGrande_Destruido[][];
    private int contador;
    private Class_General general;

    public Dialog_CARGA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.contador=1;
        this.general=new Class_General();
        this.cargarComponentes();
    }
    
    private void cargarComponentes() {
        task = new TimerTask() {
            @Override
            @SuppressWarnings("UseSpecificCatch")
            public void run() {
                
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}
                
                Asteriode = cargarARCHIVO(general.getFILA_ASTEROIDE());
                if (Asteriode != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}

                Asteriode_Destruido = cargarARCHIVO(general.getFILA_ASTERIODE_DESTRUIDO());
                if (Asteriode_Destruido != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}

                BackGround = cargarARCHIVO(general.getFILA_BACKGROUND());
                if (BackGround != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}

                Base = cargarARCHIVO(general.getFILA_BASE());
                if (Base != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}

                Avion = cargarARCHIVO(general.getFILA_AVION());
                if (Avion != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}

                Base_Destruida = cargarARCHIVO(general.getFILA_BASE_DESTRUIDA());
                if (Base_Destruida != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}

                BackGround_Destruido = cargarARCHIVO(general.getFILA_BACKGROUND_DESTRUIDO());
                if (BackGround_Destruido != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}

                asteroide_Almagedon = cargarARCHIVO(general.getFILA_ASTEROIDE_ALMAGEDON());
                if (asteroide_Almagedon != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}
                
                AsteroideGrande = cargarARCHIVO(general.getFILA_ASTEROIDE_GRANDE());
                if (AsteroideGrande != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}
                
                AsteroideGrande_Destruido = cargarARCHIVO(general.getFILA_ASTEROIDE_GRANDE_DESTRUIDO());
                if (AsteroideGrande_Destruido != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}
                
                AvionDestruido = cargarARCHIVO(general.getFILA_AVION_DESTRUIDO());
                if (AvionDestruido != null) {
                    jProgressBar1.setValue(contador++ * 100 / Class_General.NUMERO_TEXTURAS);
                } else {
                    inicializar(false);
                }
                try{
                    Thread.sleep(esperar);
                }catch(Exception e){}

                Vent_PRINCIPAL.TX_ASTEROIDE = Asteriode;
                Vent_PRINCIPAL.TX_ASTEROIDE_DESTRUIDO = Asteriode_Destruido;
                Vent_PRINCIPAL.TX_AVION = Avion;
                Vent_PRINCIPAL.TX_BASE = Base;
                Vent_PRINCIPAL.TX__BACKGROUND = BackGround;
                Vent_PRINCIPAL.TX_BACKGROUND_DESTRUIDO = BackGround_Destruido;
                Vent_PRINCIPAL.TX_BASE_DESTRUIDA = Base_Destruida;
                Vent_PRINCIPAL.TX_ASTEROIDE_ALMAGEDON = asteroide_Almagedon;
                Vent_PRINCIPAL.TX_ASTEROIDE_GRANDE = AsteroideGrande;
                Vent_PRINCIPAL.TX_ASTEROIDE_GRANDE_DESTRUIDO = AsteroideGrande_Destruido;
                Vent_PRINCIPAL.TX_AVION_DESTRUIDO=AvionDestruido;
                
                inicializar(true);
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 1);
    }
    
    private void inicializar(boolean b){
        timer.cancel();
        task.cancel();
        if (b){
            Vent_MENU.avanzar=true;
            this.dispose();
        }
        else Vent_MENU.avanzar=false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CARGANDO");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jProgressBar1.setBackground(new java.awt.Color(153, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOADING");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dialog_CARGA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_CARGA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_CARGA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_CARGA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dialog_CARGA dialog = new Dialog_CARGA(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    @SuppressWarnings({"UseSpecificCatch", "FinallyDiscardsException"})
    public Color[][] cargarARCHIVO(String st) {
        @SuppressWarnings("UnusedAssignment")
        Color array[][] = new Color[Class_General.MINIMO][Class_General.MINIMO];
        InputStream inPut;
        BufferedInputStream lector = null;
        boolean exito = false;
        int r;
        int g;
        int b;
        int a;
        int dX;
        int dY;
        try {
            inPut = this.getClass().getResourceAsStream(st);
            lector = new BufferedInputStream(inPut);
            dX = lector.read();
            dY = lector.read();
            if (dX != -1 && dY != -1) {
                array = new Color[dX][dY];
                for (int i = 0; i < dY; i++) {
                    for (int j = 0; j < dX; j++) {
                        r = lector.read();
                        g = lector.read();
                        b = lector.read();
                        a = lector.read();
                        if (r == -1 || g == -1 || b == -1 || a == -1) {
                            i = dY;
                            break;
                        } else {
                            if (a == 0) {
                                array[j][i] = null;
                            } else {
                                array[j][i] = new Color(r, g, b);
                            }
                        }
                    }
                }
                exito = true;
            }
        } catch (Exception e) {
            exito = false;
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                }
            } catch (Exception e) {
                exito = false;
            }
            if (exito) {
                return array;
            } else {
                return null;
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
