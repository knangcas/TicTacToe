import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ClientGUI extends Thread {

    boolean player1 = true;
    boolean player2 = false;

    boolean hosting;
    boolean localGame;

    boolean p2;

    int hostPort;
    int joinPort;

    boolean gate;

    String address;

    Socket sock;
    ServerSocket servSock;

    JFrame window;

    JLabel playerTurn;

    JButton lt;
    JButton ct;
    JButton rt;
    JButton lm;
    JButton cm;
    JButton rm;
    JButton lb;
    JButton cb;
    JButton rb;

    JLabel ltText;
    JLabel ctText;
    JLabel rtText;
    JLabel lmText;
    JLabel cmText;
    JLabel rmText;
    JLabel lbText;
    JLabel cbText;
    JLabel rbText;

    Stack<Integer> p1moves = new Stack<>();
    Stack<Integer> p2moves = new Stack<>();

    public ClientGUI() {

        gate = true;
        GridBagConstraints gbc = new GridBagConstraints();
        JDialog welcome = new JDialog();
        welcome.setSize(300,300);
        JButton host = new JButton("Host a Game");
        JButton join = new JButton("Join a Game");
        JButton local = new JButton("Play offline");
        JLabel welcomeText = new JLabel("Welcome to TicTacToe!");
        welcome.setLayout(new GridBagLayout());


        JDialog hostWindow = new JDialog();
        JTextField hostPortField = new JTextField();
        JLabel hostPortLabel = new JLabel("Port: ");
        JLabel hostWindowMsg = new JLabel();
        JButton hostWindowSubmit = new JButton("Submit");

        JDialog joinWindow = new JDialog();
        JTextField joinPortField = new JTextField();
        JLabel joinPortLabel = new JLabel("Port: ");
        JLabel joinWindowMsg = new JLabel();
        JButton joinWindowSubmit = new JButton("Submit");
        JTextField joinAddressField = new JTextField();
        JLabel joinAddressLabel = new JLabel("Address: ");
        joinPortLabel.setHorizontalAlignment(JLabel.RIGHT);
        joinAddressLabel.setHorizontalTextPosition(JLabel.LEFT);

        joinWindowMsg.setFont(new Font("Aria", Font.BOLD, 16));
        joinWindowMsg.setText("Enter host port");
        joinWindow.setLayout(new GridBagLayout());
        joinWindow.setSize(300, 300);


        JLabel joinMsg = new JLabel("(Port and Address of game.)");
        joinMsg.setFont(new Font("Arial", Font.PLAIN, 10));




        hostWindowMsg.setFont(new Font("Arial", Font.BOLD, 16));
        hostWindowMsg.setText("Enter host port");
        hostWindow.setLayout(new GridBagLayout());
        hostWindow.setSize(300,300);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 2;
        hostWindow.add(hostWindowMsg, gbc);
        joinWindow.add(joinWindowMsg, gbc);


        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;

        hostWindow.add(hostPortLabel, gbc);
        joinWindow.add(joinPortLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 80;
        hostWindow.add(hostPortField, gbc);
        joinWindow.add(joinPortField, gbc);

        JLabel portMsg = new JLabel("(Port range 1024-65535)");
        portMsg.setFont(new Font("Arial", Font.PLAIN, 10));




        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        hostWindow.add(portMsg, gbc);
        gbc.gridwidth = 1;
        joinWindow.add(joinAddressLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 80;
        joinWindow.add(joinAddressField, gbc);

        gbc = new GridBagConstraints();
        gbc.gridwidth = 2;
        gbc.gridy=4;
        joinWindow.add(joinMsg, gbc);






        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        hostWindow.add(hostWindowSubmit, gbc);
        gbc.gridy = 5;
        joinWindow.add(joinWindowSubmit, gbc);

        join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joinWindow.setVisible(true);
            }
        });



        gbc.gridwidth = 1;





        host.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hostWindow.setVisible(true);
            }
        });



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


        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        window.setLayout(gbl);
        window.setTitle("TicTacToe");


        window.setSize(1000,800);
        //window.setVisible(true);

        lt = new JButton();
        ct = new JButton();
        rt = new JButton();
        lm = new JButton();
        cm = new JButton();
        rm = new JButton();
        lb = new JButton();
        cb = new JButton();
        rb = new JButton();

        ltText = new JLabel();
        ctText = new JLabel();
        rtText = new JLabel();
        lmText = new JLabel();
        cmText = new JLabel();
        rmText = new JLabel();
        lbText = new JLabel();
        cbText = new JLabel();
        rbText = new JLabel();
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
                    p1moves.add(1);
                } else if(player2) {
                    ltText.setText("O");
                    player2=false;
                    player1=true;
                    lt.setEnabled(false);
                    GameLogic.playerTwoMove(1);
                    p2moves.add(1);
                    if (p2) {
                        p2moveBoard(1);
                    }
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
                    p1moves.add(2);
                } else if(player2) {
                    ctText.setText("O");
                    player2=false;
                    player1=true;
                    ct.setEnabled(false);
                    GameLogic.playerTwoMove(2);
                    p2moves.add(2);
                    if (p2) {
                        p2moveBoard(2);
                    }
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
                    p1moves.add(3);
                } else if(player2) {
                    rtText.setText("O");
                    player2=false;
                    player1=true;
                    rt.setEnabled(false);
                    GameLogic.playerTwoMove(3);
                    p2moves.add(3);
                    if (p2) {
                        p2moveBoard(3);
                    }
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
                    p1moves.add(4);
                } else if(player2) {
                    lmText.setText("O");
                    player2=false;
                    player1=true;
                    lm.setEnabled(false);
                    GameLogic.playerTwoMove(4);
                    p2moves.add(4);
                    if (p2) {
                        p2moveBoard(4);
                    }
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
                    p1moves.add(5);
                } else if(player2) {
                    cmText.setText("O");
                    player2=false;
                    player1=true;
                    cm.setEnabled(false);
                    GameLogic.playerTwoMove(5);
                    p2moves.add(5);
                    if (p2) {
                        p2moveBoard(5);
                    }
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
                    p1moves.add(6);
                } else if(player2) {
                    rmText.setText("O");
                    player2=false;
                    player1=true;
                    rm.setEnabled(false);
                    GameLogic.playerTwoMove(6);
                    p2moves.add(6);
                    if (p2) {
                        p2moveBoard(6);
                    }
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
                    p1moves.add(7);
                } else if(player2) {
                    ctText.setText("O");
                    player2=false;
                    player1=true;
                    lb.setEnabled(false);
                    GameLogic.playerTwoMove(7);
                    p2moves.add(7);
                    if (p2) {
                        p2moveBoard(7);
                    }
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
                    p1moves.add(8);
                } else if(player2) {
                    cbText.setText("O");
                    player2=false;
                    player1=true;
                    cb.setEnabled(false);
                    GameLogic.playerTwoMove(8);
                    p2moves.add(8);
                    if (p2) {
                        p2moveBoard(8);
                    }
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
                    p1moves.add(9);
                    gate=false;
                } else if(player2) {
                    rbText.setText("O");
                    player2=false;
                    player1=true;
                    rb.setEnabled(false);
                    GameLogic.playerTwoMove(9);
                    p2moves.add(9);
                    gate=false;
                    if (p2) {
                        p2moveBoard(9);
                    }
                }
            }
        });



        playerTurn = new JLabel("Placeholder");

        gbc.gridwidth = 3;
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.ipady=40;
        window.add(playerTurn, gbc);







        hostWindowSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hpf = hostPortField.getText();
                try {
                    hostPort = Integer.parseInt(hpf);
                    if (hostPort <1024 || hostPort > 65535) {
                        throw new NumberFormatException("not in range");
                    } else {
                        hosting = true;
                        localGame = false;
                        hostWindow.setVisible(false);
                        welcome.setVisible(false);

                        runGame("", hostPort);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid port number.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        joinWindowSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                boolean show = true;
                if (joinPortField.getText().isEmpty() || joinAddressField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter required fields", "ERROR", JOptionPane.ERROR_MESSAGE);
                    show = false;
                }

                String jpf = joinPortField.getText();
                address = joinAddressField.getText();



                try {
                    joinPort = Integer.parseInt(jpf);
                    if (joinPort<1024 || joinPort >65535) {
                        throw new NumberFormatException("not in range");
                    } else {
                        hosting = false;
                        p2 = true;
                        joinWindow.setVisible(false);
                        welcome.setVisible(false);
                        runGame(address, joinPort);
                    }
                } catch (NumberFormatException nfe) {
                    if (show) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid port number.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }


            }
        });

        local.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hosting = false;
                localGame = true;
                runGame("",0);
                welcome.dispose();

            }
        });




    }


    public static void main(String[] args) {

        ClientGUI main = new ClientGUI();


       // main.setVisible(true);

    }

    public void run(){

        window.setVisible(true);
        if (hosting) {
            System.out.println("Hosting a game on port: " + hostPort);
            DataOutputStream dos = null;
            DataInputStream dis = null;
            try {
                servSock = new ServerSocket(hostPort);
                System.out.println("Waiting for connection...");
                sock = servSock.accept();
                System.out.println("Connected!");
                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());
            } catch (IOException e) {
                System.out.println("exception");
            }



            while(true) {
                if (player1) {
                    if (GameLogic.checkVictoryP2()) {
                        //TODO
                        JOptionPane.showMessageDialog(null, "Player2 wins", "Notice", JOptionPane.INFORMATION_MESSAGE);
                    }
                    playerTurn.setText("Player1's turn");
                    while(gate){};
                    JSONObject send = new JSONObject();
                    send.put("p1move", p1moves.peek());
                    try {
                        dos.writeUTF(send.toString());
                    } catch (IOException e) {
                        //TODO
                    }
                } else if (player2) {
                    playerTurn.setText("Player2's turn");
                    if (GameLogic.checkVictoryP1()) {
                        //TODO
                        JOptionPane.showMessageDialog(null, "Player1 wins", "Notice", JOptionPane.INFORMATION_MESSAGE);
                    }
                    String player2move = null;
                    try {
                        player2move = dis.readUTF();
                    } catch (IOException e) {
                        //TODO
                    }
                    try {
                        JSONObject fromP2 = new JSONObject(player2move);
                        p2moves.push(fromP2.getInt("p2move"));
                    } catch (Exception e) {
                        //TODO
                    }

                    GameLogic.playerTwoMove(p2moves.peek());
                }

            }

        }

        if (!hosting && p2) {
            player1=false;
            player2=true;
            DataOutputStream dos = null;
            DataInputStream dis = null;
            try {
                System.out.println("Connecting to..." + address + ":" + joinPort);
                sock = new Socket(address, joinPort);
                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());
            } catch (IOException e) {
                //TODO
            }

            while(true) {
                if (player2) {
                    if (GameLogic.checkVictoryP1()) {
                        //TODO
                        JOptionPane.showMessageDialog(null, "Player1 wins", "Notice", JOptionPane.INFORMATION_MESSAGE);
                    }
                    playerTurn.setText("Player2's turn");
                    while(gate){}
                    JSONObject send = new JSONObject();
                    send.put("p1move", p1moves.peek());
                    try {
                        dos.writeUTF(send.toString());
                    } catch (IOException e) {
                        //TODO
                    }
                    player1=false;
                    player2=true;
                } else if (player1) {
                    playerTurn.setText("Player1's turn");
                    if (GameLogic.checkVictoryP2()) {
                        //TODO
                        JOptionPane.showMessageDialog(null, "Player2 wins", "Notice", JOptionPane.INFORMATION_MESSAGE);
                    }
                    String player2move = null;
                    try {
                        player2move = dis.readUTF();
                    } catch (IOException e) {
                        //TODO
                    }
                    try {
                        JSONObject fromP2 = new JSONObject(player2move);
                        p2moves.push(fromP2.getInt("p2move"));
                    } catch (Exception e) {
                        //TODO
                    }
                    GameLogic.playerTwoMove(p2moves.peek());
                }
            }
        }

        if (!hosting && localGame) {
            System.out.println("Playing local game");
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

    private void p2moveBoard(int n) {
        switch (n) {
            case 1:
                lt.doClick();
                break;
            case 2:
                ct.doClick();
                break;
            case 3:
                rt.doClick();
                break;
            case 4:
                lm.doClick();
                break;
            case 5:
                cm.doClick();
                break;
            case 6:
                rm.doClick();
                break;
            case 7:
                lb.doClick();
                break;
            case 8:
                cb.doClick();
                break;
            case 9:
                rb.doClick();
                break;
        }


    }
}