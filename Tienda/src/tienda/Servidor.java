package tienda;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
    
    public static ArrayList<Producto> productos = new ArrayList<Producto>();

    public static void main(String[] args) {
        int puerto = 8000;
        DatagramPacket dp = null;
        DatagramSocket s = null;
   
        ObjectInputStream ois = null;
        Celular c2 = null;
        
        /*-----DECLARAMOS TODOS LOS PRODUCTOS-----*/
        //int id, String nombre, float precio, String descripcion, String nImg
        productos.add(new Producto(1,"Audifonos",299.9,"Adifonos JBL Azules","audifonos"));
        
        

        try {
            s = new DatagramSocket(puerto);
            System.out.println("Servidor UDP iniciado en el puerto " + s.getLocalPort());
            System.out.println("Recibiendo datos...");
            for (int i = 0; i < 10; i++) {

                dp = new DatagramPacket(new byte[1024], 1024);
                s.receive(dp);

                System.out.println("Datagrama recibido... extrayendo informacion");
                System.out.println("Host remoto:" + dp.getAddress().getHostAddress() + ":" + dp.getPort());
                System.out.println("Datos del paquete:");

                ois = new ObjectInputStream(new ByteArrayInputStream(dp.getData()));
                c2 = (Celular) ois.readObject();
                
                System.out.println("El precio del celular = "+c2.getPrecio());
                
                ois.close();
            }//for
            s.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Termina el contenido del datagrama...");
    }//main
}//class
