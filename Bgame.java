/******
*@Programa: Papeleria
*Autor:    Bernabe Torres David Leónidas
*Fecha:    04/08/2022
*Descripción: 
*******/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bgame extends JFrame implements ActionListener {

    private Game Game = new Game();

    private JLabel[] lb = new JLabel[10];
    private JButton[] btn =  new JButton[3];
    private String bt[]={"Cerrar aplicacion", "Jugar", "Continuar"};
    private JPasswordField pw;
    private JTextField usr;
    Font a = new Font("Minecraft", Font.PLAIN, 18); 

    public static void main(String[] args) {
        Bgame demo = new Bgame();
        demo. setBounds(500,150,800,360);
        demo.setVisible(true);
        demo.setTitle(" Chessito ");
    }

    public Bgame() {
        setLayout(null);
        Container ventana = getContentPane();

        lb[0] = new JLabel("Chessito");
        lb[0].setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
        lb[0].setBounds(285,0,280,80);
        ventana.add(lb[0]);

        lb[1] = new JLabel(new ImageIcon("tower.png"));
        lb[1].setBounds(10,40,238,244);
        ventana.add(lb[1]);

        lb[2] = new JLabel(new ImageIcon("horse.png"));
        lb[2].setBounds(630,40,176,244);
        ventana.add(lb[2]);

        lb[3] = new JLabel("Autores: ");
        lb[3].setFont(new Font("Minecraft", Font.PLAIN, 30));
        lb[3].setBounds(250,100,150,30);
        ventana.add(lb[3]);

        lb[4] = new JLabel(" @Daf get34  //  @DNAFoxy ");
        lb[4].setFont(new Font("Minecraft", Font.PLAIN, 18));
        lb[4].setBounds(385,105,300,30);
        ventana.add(lb[4]);

        lb[5] = new JLabel("Usuario: ");
        lb[5].setFont(new Font("Minecraft", Font.PLAIN, 27));
        lb[5].setBounds(255,150,200,30);
        ventana.add(lb[5]);

        usr = new JTextField();
        usr.setBounds(360,152,255,30);
        ventana.add(usr);

        lb[6] = new JLabel("Contraseña: ");
        lb[6].setFont(new Font("Minecraft", Font.PLAIN, 27));
        lb[6].setBounds(255,190,200,30);
        ventana.add(lb[6]);

        pw = new JPasswordField(); 
        pw.setBounds(415,192,200,30);
        ventana.add(pw);

        for(int e=0, x=275; e<3; e++, x+=160){
            btn[e] = new JButton(bt[e]);
            if(e==2){
                x=330;
                btn[e].setVisible(false);
            }
            btn[e].setBounds(x, 280, 140, 40);
            ventana.add(btn[e]);
            btn[e].addActionListener( this); 
        }

    }

    public void actionPerformed(ActionEvent event) {
        Object origen= event.getSource();
        String[] a= new String[1];

        if(origen == btn[1]){
            for(int e=1; e<7; e++) lb[e].setVisible(false);
            for(int e=0; e<2; e++) btn[e].setVisible(false);
            pw.setVisible(false);
            usr. setVisible(false);
            lb[0].setBounds(260,0,280,80);
            btn[2].setVisible(true);

        } else if(origen == btn[2]) Game.main(a);
        else System.exit(0);
                

    
    }
}

// Hi this is a prove of actualization of code in git-hub 

