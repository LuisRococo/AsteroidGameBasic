
package Principal;

import Componentes.Class_ASTE_ALMAGEDON;
import Componentes.Class_Asteriode;
import Componentes.Class_AsteroideGrande;
import Componentes.Class_Avion;
import Componentes.Class_Base;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Vent_PRINCIPAL extends javax.swing.JFrame implements KeyListener{

    //TASK Y TIMER
    private Timer timer;
    private TimerTask task;
    //TEXTURAS
    public static Color[][]TX_ASTEROIDE;
    public static Color[][]TX_ASTEROIDE_DESTRUIDO;
    public static Color[][]TX_AVION;
    public static Color[][]TX_AVION_DESTRUIDO;
    public static Color[][]TX__BACKGROUND;
    public static Color[][]TX_BASE;
    public static Color[][]TX_BACKGROUND_DESTRUIDO;
    public static Color[][]TX_BASE_DESTRUIDA;
    public static Color[][]TX_ASTEROIDE_ALMAGEDON;
    public static Color[][]TX_ASTEROIDE_GRANDE;
    public static Color[][]TX_ASTEROIDE_GRANDE_DESTRUIDO;
    //DEMAS
    private final Panel_Dibujo lienzo;
    private final Class_Cañon cañon;
    @SuppressWarnings("LeakingThisInConstructor")
    public Vent_PRINCIPAL() {
        initComponents();
        cargarTexturasEstaticas(); //ESTO DEBE SER LO PRIMERO
        this.setFocusable(true);
        this.addKeyListener(this);
        this.jTextField1.setText("0");
        jPanel2.setPreferredSize(new Dimension(700, 700));
        jPanel2.setSize(700, 700);
        this.cañon = new Class_Cañon(jPanel2.getSize());
        lienzo = new Panel_Dibujo(jPanel2.getSize(), this.cañon);
        jPanel2.add(lienzo);
        timer = new Timer();
        motorCorazon(); //ESTO HASTA LO ULTIMO
    }
    
    private void motorCorazon(){
        task=new TimerTask() {
            @Override
            public void run() {
                try {
                    lienzo.detectarImpacto();
                    lienzo.actualizarLanzadores();
                    lienzo.actualizarBalas();
                    lienzo.actualizarAsteroides();
                    lienzo.actualizarAsteroidesG();
                    lienzo.actualizarAviones();
                    jTextField1.setText(String.valueOf(lienzo.getPuntuacion()));
                    lienzo.repaint();
                    if (lienzo.isGameOver()) {
                        gameOver();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR INESPERADO");
                    System.exit(0);
                    dispose();
                }
            }
        };
        timer.schedule(task, 100, 50);
    }
    
    public void gameOver(){
        lienzo.setAlmagedonOn();
        Class_Base.cambiar_TexturaDestruida();
        lienzo.setTexturaGameOver(TX_BACKGROUND_DESTRUIDO);
        lienzo.gameOverLimpiarTodo();
        
        timer.cancel();
        task.cancel();
        timer=new Timer();
        task=new TimerTask() {
            @Override
            public void run() {
                if (lienzo.actualizarGameOver()){
                    gameOverTrue();
                }
                else{
                    lienzo.repaint();
                }
            }
        };
        timer.schedule(task, 0, 500);
    }
    
    public void gameOverTrue(){
        Vent_GAMEOVER vent=new Vent_GAMEOVER(lienzo.getPuntuacion());
        this.timer.cancel();
        this.task.cancel();
        vent.setLocationRelativeTo(this);
        vent.setVisible(true);
        this.dispose();
    }
    
    public void cargarTexturasEstaticas(){
        Class_Asteriode.inicializarTEXTURAS(TX_ASTEROIDE,TX_ASTEROIDE_DESTRUIDO); //NULL POR MIENTRAS
        Class_Avion.inicializarTEXTURAS(TX_AVION, TX_AVION);
        Class_Base.inicializarTEXTURAS(TX_BASE, TX_BASE_DESTRUIDA);
        Panel_Dibujo.setTexturaPrincipale(TX__BACKGROUND);
        Class_ASTE_ALMAGEDON.inicializarTEXTURAS(TX_ASTEROIDE_ALMAGEDON);
        Class_AsteroideGrande.inicializarTEXTURAS(TX_ASTEROIDE_GRANDE, TX_ASTEROIDE_GRANDE_DESTRUIDO);
        Class_Avion.inicializarTEXTURAS(TX_AVION, TX_AVION_DESTRUIDO);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setText("SALIR");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SCORE");

        jTextField1.setEditable(false);
        jTextField1.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
 
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
            java.util.logging.Logger.getLogger(Vent_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vent_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vent_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vent_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Vent_PRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                cañon.moverIZQ();
                break;
            case KeyEvent.VK_RIGHT:
                cañon.moverDER();
                break;
            case KeyEvent.VK_SPACE:
                cañon.disparar();
                break;
            default:
                break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
