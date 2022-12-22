/******
*@Programa: Ajedrez
*Autor:    @DNAFx=y   @Dafget34
*Fecha:    04/08/2022
*Descripción: 
*******/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {
    
    public JLabel lb; 
    public JButton[][] cell =  new JButton[8][8];
    public int[][] pos = new int[8][8];
    int cpy=0, x, y, xi, yi, trn=0;

    public static void main(String[] args) {
        Game demo = new Game();
        demo. setBounds(500,150,1000,1000);
        demo.setVisible(true);
        demo.setTitle(" Juego ");
    }

    public Game() {
        setLayout(null);
        Container ventana = getContentPane();

        lb = new JLabel("En construccion...");
        lb.setBounds(190,20,150,20);
        ventana.add(lb);

        for(int y=0, y1=50; y<8; y++, y1+=99) {
            for(int x=0, x1=15; x<8; x++, x1+=99) {
                cell[x][y] = new JButton("");
                cell[x][y].setBounds(x1, y1, 100, 100);
                ventana.add(cell[x][y]);
                cell[x][y].addActionListener( this); 
                if(y%2==0) if(x%2!=0) cell[x][y].setBackground(Color.GRAY);
                if(y%2!=0) if(x%2==0) cell[x][y].setBackground(Color.GRAY);
            }
        }

        for(int x=-1, val=7; x<4; x++, val--, pos[x][0]=val, pos[x][7]=val+10);
        for(int x=4, val=3; x<7; x++, val++, pos[x][0]=val, pos[x][7]=val+10);
        for(int x=-1; x<7; x++, pos[x][1]=1, pos[x][6]=11);        

        for(int y=0; y<8; y++) {
            for(int x=0; x<8; x++) {
                for(int i=6; i>0; i--){
                    if(pos[x][y]==i) cell[x][y].setIcon(new ImageIcon("pieces/"+i+".png"));
                    if(pos[x][y]==i+10) cell[x][y].setIcon(new ImageIcon("pieces/"+(i+10)+".png"));
                }
            } 
        } 

    }

    public void actionPerformed(ActionEvent event) {
        Object origen= event.getSource();  
        
        for(int y=0; y<8; y++) {
            for(int x=0; x<8; x++) {
                if(cpy==0){
                    if(origen == cell[x][y]){
                        if(pos[x][y]==0) break;
                        xi=x;
                        yi=y;
                        cpy=1;
                    }
                } else{
                    if(origen == cell[x][y]){
                        // if(pos[xi][yi]==pos[x][y]) break;
                        cell[xi][yi].setIcon(new ImageIcon(""));
                        cell[x][y].setIcon(new ImageIcon("pieces/"+pos[xi][yi]+".png"));
                        pos[x][y]=pos[xi][yi];
                        pos[xi][yi]=0;

                        cpy=0; 
                    }
                }
            } 
        } 
        
    }
}


// Que no se coma a si misma

// Pa que no se coman entre si podemos limitarlos por rangos :)
