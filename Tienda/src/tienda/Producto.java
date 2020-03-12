package tienda;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private String descripcion;
    private String nImg;
    
    public Producto(int id, String nombre, double precio, String descripcion, String nImg){
        
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nImg = nImg;
    }
    
    public int getId(){ return this.id; }
    
    public String getNombre(){ return this.nombre; }
    
    public double getPrecio(){ return this.precio; }
    
    public String getDescrip(){ return this.descripcion; }
    
    public String getImg(){ return this.nImg; }
}
