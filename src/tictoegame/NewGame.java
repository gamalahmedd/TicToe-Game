package tictoegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class NewGame extends javax.swing.JFrame {

    
    public NewGame() {
        initComponents();
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new StartGame().setVisible(true);
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to close game?","Select",JOptionPane.YES_NO_OPTION);
                if(a == 0){
                    System.exit(0);
                }
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnStart = new swing.ButtonGradient();
        btnClose = new swing.ButtonGradient();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnStart.setText("Start New Game");
        btnStart.setColor1(new java.awt.Color(0, 0, 0));
        btnStart.setColor2(new java.awt.Color(190, 197, 139));
        btnStart.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 290, 103));

        btnClose.setText("Close");
        btnClose.setColor1(new java.awt.Color(0, 0, 0));
        btnClose.setColor2(new java.awt.Color(190, 197, 139));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 290, 103));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/2078959.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -170, 720, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btnClose;
    private swing.ButtonGradient btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
