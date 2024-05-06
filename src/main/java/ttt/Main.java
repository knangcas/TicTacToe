package ttt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static boolean player1 = true;
    static boolean player2 = false;

    boolean host;
    boolean local;


    public static void main(String[] args) {


        JDialog welcome = new JDialog();
        welcome.setSize(300,300);
        JButton host = new JButton("Host a Game");
        JButton join = new JButton("Join a Game");
        JButton local = new JButton("Play offline");
        JLabel welcomeText = new JLabel("Welcome to TicTacToe!");
        welcome.setLayout(new GridBagLayout());


        JDialog hostWindow = new JDialog();
        JTextField hostPort = new JTextField();
        JLabel hostPostLabel = new JLabel();


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy=0;
        gbc.gridx=0;
        welcomeText.setFont(new Font("Arial", Font.BOLD, 20));

        welcome.add(welcomeText, gbc);

        gbc.gridy=1;
        gbc.gridx=0;

        welcome.add(host, gbc);

        gbc.gridy=2;
        gbc.gridx=0;

        welcome.add(join, gbc);

        gbc.gridy=3;
        gbc.gridx=0;
        welcome.add(local, gbc);

        welcome.setVisible(true);




        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        window.setLayout(gbl);
        window.setTitle("TicTacToe");
        window.setVisible(true);
        window.setSize(1000,1000);

        JButton lt = new JButton();
        JButton ct = new JButton();
        JButton rt = new JButton();
        JButton lm = new JButton();
        JButton cm = new JButton();
        JButton rm = new JButton();
        JButton lb = new JButton();
        JButton cb = new JButton();
        JButton rb = new JButton();

        JLabel ltText = new JLabel();
        JLabel ctText = new JLabel();
        JLabel rtText = new JLabel();
        JLabel lmText = new JLabel();
        JLabel cmText = new JLabel();
        JLabel rmText = new JLabel();
        JLabel lbText = new JLabel();
        JLabel cbText = new JLabel();
        JLabel rbText = new JLabel();
        JLabel title = new JLabel("TicTacToe");


        title.setFont(new Font("Arial", Font.PLAIN, 20));


        gbc.gridwidth = 3;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.ipady = 100;
        window.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy=1;
        gbc.gridx=0;
        gbc.ipady = 30;
        window.add(lt, gbc);
        lt.setRolloverEnabled(false);
        ltText.setFont(new Font("Arial", Font.BOLD, 12));

        lt.add(ltText);
        lt.setBackground(Color.WHITE);
        lt.setForeground(Color.white);
        lt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    ltText.setText("X");
                    player1=false;
                    player2=true;
                    lt.setEnabled(false);
                    GameLogic.playerOneMove(1);
                } else if(player2) {
                    ltText.setText("O");
                    player2=false;
                    player1=true;
                    lt.setEnabled(false);
                    GameLogic.playerTwoMove(1);
                }
            }
        });




        gbc.gridwidth = 1;
        gbc.gridy=1;
        gbc.gridx=1;
        gbc.ipady = 30;
        window.add(ct, gbc);
        ctText.setFont(new Font("Arial", Font.BOLD, 12));
        ct.add(ctText);
        ct.setBackground(Color.WHITE);
        ct.setForeground(Color.white);
        ct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    ctText.setText("X");
                    player1=false;
                    player2=true;
                    ct.setEnabled(false);
                    GameLogic.playerOneMove(2);
                } else if(player2) {
                    ctText.setText("O");
                    player2=false;
                    player1=true;
                    ct.setEnabled(false);
                    GameLogic.playerTwoMove(2);
                }
            }
        });

        gbc.gridwidth = 1;
        gbc.gridy=1;
        gbc.gridx=2;
        gbc.ipady = 30;
        window.add(rt, gbc);
        rtText.setFont(new Font("Arial", Font.BOLD, 12));
        rt.add(rtText);
        rt.setBackground(Color.WHITE);
        rt.setForeground(Color.white);
        rt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    rtText.setText("X");
                    player1=false;
                    player2=true;
                    rt.setEnabled(false);
                    GameLogic.playerOneMove(3);
                } else if(player2) {
                    rtText.setText("O");
                    player2=false;
                    player1=true;
                    rt.setEnabled(false);
                    GameLogic.playerTwoMove(3);
                }
            }
        });

        gbc.gridwidth = 1;
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.ipady = 30;
        window.add(lm, gbc);
        lmText.setFont(new Font("Arial", Font.BOLD, 12));
        lm.add(lmText);
        lm.setBackground(Color.WHITE);
        lm.setForeground(Color.white);
        lm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    lmText.setText("X");
                    player1=false;
                    player2=true;
                    lm.setEnabled(false);
                    GameLogic.playerOneMove(4);
                } else if(player2) {
                    lmText.setText("O");
                    player2=false;
                    player1=true;
                    lm.setEnabled(false);
                    GameLogic.playerTwoMove(4);
                }
            }
        });

        gbc.gridwidth = 1;
        gbc.gridy=2;
        gbc.gridx=1;
        gbc.ipady = 30;
        window.add(cm, gbc);
        cmText.setFont(new Font("Arial", Font.BOLD, 12));
        cm.add(cmText);
        cm.setBackground(Color.WHITE);
        cm.setForeground(Color.white);
        cm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    cmText.setText("X");
                    player1=false;
                    player2=true;
                    cm.setEnabled(false);
                    GameLogic.playerOneMove(5);
                } else if(player2) {
                    cmText.setText("O");
                    player2=false;
                    player1=true;
                    cm.setEnabled(false);
                    GameLogic.playerTwoMove(5);
                }
            }
        });

        gbc.gridwidth = 1;
        gbc.gridy=2;
        gbc.gridx=2;
        gbc.ipady = 30;
        window.add(rm, gbc);
        rmText.setFont(new Font("Arial", Font.BOLD, 12));
        rm.add(rmText);
        rm.setBackground(Color.WHITE);
        rm.setForeground(Color.white);
        rm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    rmText.setText("X");
                    player1=false;
                    player2=true;
                    rm.setEnabled(false);
                    GameLogic.playerOneMove(6);
                } else if(player2) {
                    rmText.setText("O");
                    player2=false;
                    player1=true;
                    rm.setEnabled(false);
                    GameLogic.playerTwoMove(6);
                }
            }
        });

        gbc.gridwidth = 1;
        gbc.gridy=3;
        gbc.gridx=0;
        gbc.ipady = 30;
        window.add(lb, gbc);
        lbText.setFont(new Font("Arial", Font.BOLD, 12));
        lb.add(lbText);
        lb.setBackground(Color.WHITE);
        lb.setForeground(Color.white);
        lb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    lbText.setText("X");
                    player1=false;
                    player2=true;
                    lb.setEnabled(false);
                    GameLogic.playerOneMove(7);
                } else if(player2) {
                    ctText.setText("O");
                    player2=false;
                    player1=true;
                    lb.setEnabled(false);
                    GameLogic.playerTwoMove(7);
                }
            }
        });

        gbc.gridwidth = 1;
        gbc.gridy=3;
        gbc.gridx=1;
        gbc.ipady = 30;
        window.add(cb, gbc);
        cbText.setFont(new Font("Arial", Font.BOLD, 12));
        cb.add(cbText);
        cb.setBackground(Color.WHITE);
        cb.setForeground(Color.white);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    cbText.setText("X");
                    player1=false;
                    player2=true;
                    cb.setEnabled(false);
                    GameLogic.playerOneMove(8);
                } else if(player2) {
                    cbText.setText("O");
                    player2=false;
                    player1=true;
                    cb.setEnabled(false);
                    GameLogic.playerTwoMove(8);
                }
            }
        });


        gbc.gridwidth = 1;
        gbc.gridy=3;
        gbc.gridx=2;
        gbc.ipady = 30;
        window.add(rb, gbc);
        rbText.setFont(new Font("Arial", Font.BOLD, 12));
        rb.add(rbText);
        rb.setBackground(Color.WHITE);
        rb.setForeground(Color.white);
        rb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player1) {
                    rbText.setText("X");
                    player1=false;
                    player2=true;
                    rb.setEnabled(false);
                    GameLogic.playerOneMove(9);
                } else if(player2) {
                    rbText.setText("O");
                    player2=false;
                    player1=true;
                    rb.setEnabled(false);
                    GameLogic.playerTwoMove(9);
                }
            }
        });



        JLabel playerTurn = new JLabel("Placeholder");

        gbc.gridwidth = 3;
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.ipady=40;
        window.add(playerTurn, gbc);



        while(true) {
            if (player1) {
                if (GameLogic.checkVictoryP2()) {

                }
                playerTurn.setText("Player1's turn");
                //System.out.println("player1move");
            }
            if (player2) {
                if (GameLogic.checkVictoryP1()) {
                    JOptionPane.showMessageDialog(null, "Player1 wins", "Notice", JOptionPane.INFORMATION_MESSAGE);
                }
                playerTurn.setText("Player2's turn");
                //System.out.println("player2move");
            }

        }







    }
}