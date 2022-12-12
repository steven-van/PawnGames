package swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JeuOthello extends JMenuBar {
	 
    public JeuOthello() {
        super();
        setMenu();
    }
 
    private void setMenu() {
        JMenu menuPartie = new JMenu("Partie");
        JMenuItem nouvellePartie = new JMenuItem("Nouvelle Partie");
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
 
        menuPartie.add(nouvellePartie);
        menuPartie.add(quitter);
        add(menuPartie);
 
        JMenu aPropos = new JMenu("?");
        JMenuItem regles = new JMenuItem("Règles du jeu");
        regles.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"...","Règles du jeu",JOptionPane.PLAIN_MESSAGE);              
            }
        });
        aPropos.add(regles);
        add(aPropos);
    }
 
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel p = new JPanel();
        p.setLayout(new GridLayout (10, 10));
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                JButton b = new JButton();
                if ((i + j) % 2 == 0) {
                    b.setBackground(Color.white);
                } else {
                    b.setBackground(Color.BLACK);
                }
                p.add(b);
            }
        }
        frame.add(p);
        frame.setJMenuBar(new JeuOthello());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500); //On donne une taille à notre fenêtre
        frame.setTitle("Othello");
        frame.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        frame.setResizable(false); //On interdit la redimensionnement de la fenêtre
        frame.setVisible(true);
    }
}


