package tictoegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class StartGame extends javax.swing.JFrame {

    public String[][] board = new String[3][3];

    public StartGame() {
        initComponents();
        lblComputer.setVisible(false);
        lblPlayer.setVisible(false);
        lblDraw.setVisible(false);
        txtContinue.setVisible(false);
        btn10.setVisible(false);
        insertArrayinitial();
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(0, 0);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(0, 1);
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(0, 2);
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(1, 0);
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(1, 1);
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(1, 2);
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(2, 0);
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(2, 1);
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(2, 2);
            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new NewGame().setVisible(true);
            }
        });
    }

    public void insertArrayinitial() {
        board[0][0] = "";
        board[0][1] = "";
        board[0][2] = "";
        board[1][0] = "";
        board[1][1] = "";
        board[1][2] = "";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
    }

    public void insertAtButton(int i, int j, String xo) {
        if (i == 0 && j == 0) {
            btn1.setText(xo);
        } else if (i == 0 && j == 1) {
            btn2.setText(xo);
        } else if (i == 0 && j == 2) {
            btn3.setText(xo);
        } else if (i == 1 && j == 0) {
            btn4.setText(xo);
        } else if (i == 1 && j == 1) {
            btn5.setText(xo);
        } else if (i == 1 && j == 2) {
            btn6.setText(xo);
        } else if (i == 2 && j == 0) {
            btn7.setText(xo);
        } else if (i == 2 & j == 1) {
            btn8.setText(xo);
        } else if (i == 2 & j == 2) {
            btn9.setText(xo);
        } else {
            JOptionPane.showMessageDialog(null, "Wrong insert");
        }
    }

    public void Main(int x, int y) {
        try {
            String player = "X";
            if (board[x][y].equals("")) {
                board[x][y] = player;
                insertAtButton(x, y, player);
                int result = miniMax(board, 100, false, true);
                System.out.println(result);
                switch (result) {
                    case 2:
                        int check1 = checkWinner(board);
                        if (check1 == 2) {
                            lblPlayer.setVisible(true);
                            btn10.setVisible(true);
                        }
                        break;

                    case -2:
                        int check = checkWinner(board);
                        if (check == -2) {
                            lblComputer.setVisible(true);
                            btn10.setVisible(true);
                        }
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "The Field Is Not Empty");
            }
            int result = checkWinner(board);
            if (result == 0) {
                lblDraw.setVisible(true);
                btn10.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    boolean haveTheSameValueAndNotEmpty(String x, String y, String z) {
        if (x.equals(y) && x.equals(z) && !x.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    int checkWinner(String[][] board
    ) {
        // 2: X Winner
        // -2: O Winner
        // 0: Tie
        // 1: No Winner

        // For rows
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValueAndNotEmpty(board[i][0], board[i][1], board[i][2])) {
                return board[i][0].equals("X") ? 2 : -2;
            }
        }

        // For cols
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValueAndNotEmpty(board[0][i], board[1][i], board[2][i])) {
                return board[0][i].equals("X") ? 2 : -2;
            }
        }

        // Diameter 1
        if (haveTheSameValueAndNotEmpty(board[0][0], board[1][1], board[2][2])) {
            return board[0][0].equals("X") ? 2 : -2;
        }

        // Diameter 2
        if (haveTheSameValueAndNotEmpty(board[2][0], board[1][1], board[0][2])) {
            return board[2][0].equals("X") ? 2 : -2;
        }

        // For Tie Case
        boolean tie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("")) {
                    tie = false;
                }
            }
        }
        if (tie) {
            return 0;
        }

        // Else
        return 1;
    }

    int miniMax(String[][] board, int depth, boolean isMaximizing, boolean firstTime
    ) {
        int result = checkWinner(board);
        if (depth == 0 || result != 1) {
            return result;
        }

        if (isMaximizing) {
            int finalscore = -10;
            int finalI = -1, finalJ = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals("")) {
                        board[i][j] = "X";
                        insertAtButton(i, j, "X");
                        int score = miniMax(board, depth - 1, false, false);
                        board[i][j] = "";
                        insertAtButton(i, j, "");
                        if (score > finalscore) {
                            finalscore = score;
                            finalI = i;
                            finalJ = j;
                        }
                        if (firstTime) {
                            System.out.println("score," + i + "," + j + ": " + score + "\n");
                        }
                    }
                }
            }
            if (firstTime) {
                board[finalI][finalJ] = "O";
                insertAtButton(finalI, finalJ, "O");
            }
            return finalscore;
        } else {
            int finalscore = 10;
            int finalI = -1, finalJ = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals("")) {
                        board[i][j] = "O";
                        insertAtButton(i, j, "O");
                        int score = miniMax(board, depth - 1, true, false);
                        board[i][j] = "";
                        insertAtButton(i, j, "");
                        if (score < finalscore) {
                            finalscore = score;
                            finalI = i;
                            finalJ = j;
                        }
                        if (firstTime) {
                            System.out.println("score," + i + "," + j + ": " + score + "\n");
                        }
                    }
                }
            }
            if (firstTime) {
                board[finalI][finalJ] = "O";
                insertAtButton(finalI, finalJ, "O");
            }
            return finalscore;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtContinue = new javax.swing.JLabel();
        lblDraw = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblComputer = new javax.swing.JLabel();
        btn3 = new swing.ButtonGradient();
        btn1 = new swing.ButtonGradient();
        btn2 = new swing.ButtonGradient();
        btn5 = new swing.ButtonGradient();
        btn4 = new swing.ButtonGradient();
        btn6 = new swing.ButtonGradient();
        btn7 = new swing.ButtonGradient();
        btn8 = new swing.ButtonGradient();
        btn10 = new swing.ButtonGradient();
        btn9 = new swing.ButtonGradient();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContinue.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        txtContinue.setText("CONTINUE");
        getContentPane().add(txtContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, -1, -1));

        lblDraw.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        lblDraw.setText("draw!");
        getContentPane().add(lblDraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, -1, -1));

        lblPlayer.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        lblPlayer.setText("PLAYER WINS!");
        getContentPane().add(lblPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, -1, -1));

        lblComputer.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        lblComputer.setText("computer wins!");
        getContentPane().add(lblComputer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, -1, -1));

        btn3.setColor1(new java.awt.Color(0, 0, 0));
        btn3.setColor2(new java.awt.Color(190, 197, 139));
        btn3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 72, 107, 103));

        btn1.setColor1(new java.awt.Color(0, 0, 0));
        btn1.setColor2(new java.awt.Color(190, 197, 139));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 72, 107, 103));

        btn2.setColor1(new java.awt.Color(0, 0, 0));
        btn2.setColor2(new java.awt.Color(190, 197, 139));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 72, 107, 103));

        btn5.setColor1(new java.awt.Color(0, 0, 0));
        btn5.setColor2(new java.awt.Color(190, 197, 139));
        btn5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 219, 107, 103));

        btn4.setColor1(new java.awt.Color(0, 0, 0));
        btn4.setColor2(new java.awt.Color(190, 197, 139));
        btn4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 219, 107, 103));

        btn6.setColor1(new java.awt.Color(0, 0, 0));
        btn6.setColor2(new java.awt.Color(190, 197, 139));
        btn6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 219, 107, 103));

        btn7.setColor1(new java.awt.Color(0, 0, 0));
        btn7.setColor2(new java.awt.Color(190, 197, 139));
        btn7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 366, 107, 103));

        btn8.setColor1(new java.awt.Color(0, 0, 0));
        btn8.setColor2(new java.awt.Color(190, 197, 139));
        btn8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 366, 107, 103));

        btn10.setText("Play New Game");
        btn10.setColor1(new java.awt.Color(0, 0, 0));
        btn10.setColor2(new java.awt.Color(190, 197, 139));
        btn10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 250, 60));

        btn9.setColor1(new java.awt.Color(0, 0, 0));
        btn9.setColor2(new java.awt.Color(190, 197, 139));
        btn9.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 366, 107, 103));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/2078959.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed

    }//GEN-LAST:event_btn1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btn1;
    private swing.ButtonGradient btn10;
    private swing.ButtonGradient btn2;
    private swing.ButtonGradient btn3;
    private swing.ButtonGradient btn4;
    private swing.ButtonGradient btn5;
    private swing.ButtonGradient btn6;
    private swing.ButtonGradient btn7;
    private swing.ButtonGradient btn8;
    private swing.ButtonGradient btn9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblComputer;
    private javax.swing.JLabel lblDraw;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel txtContinue;
    // End of variables declaration//GEN-END:variables
}
