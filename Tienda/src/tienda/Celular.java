package tienda;

import java.io.Serializable;

public class Celular implements Serializable {
    
    int precio;
    
    public Celular(int p){
        this.precio = p;
    }
    
    public int getPrecio(){ return this.precio;}
    
}