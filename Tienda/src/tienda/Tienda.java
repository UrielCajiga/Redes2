package tienda;

import java.awt.Color;
import javax.swing.JFrame;

public class Tienda extends JFrame{

    public Tienda() {
        setSize(500,500);
        setTitle("Tienda en linea"); 
        setLocationRelativeTo(null);
        
        //this.getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }   
    
    
    public static void main(String[] args) {
        
    }
    
}
