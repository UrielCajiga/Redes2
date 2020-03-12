package tienda;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {

    public static ArrayList<Producto> productos = new ArrayList<Producto>();
    public static DatagramPacket dp = null;
    public static DatagramSocket s = null;
    public static ObjectInputStream ois = null;
    public static ObjectOutputStream oos = null;
    public static ByteArrayOutputStream baos = null;
    public static ByteArrayInputStream bais = null;
    public static byte[] buf = null;

    public static void enviarObjeto(Producto obj) throws Exception {

        baos = new ByteArrayOutputStream();//Creamos el arreglo de bites
        oos = new ObjectOutputStream(baos);//Creamos una salida con el arreglo bits como parametros
        buf = new byte[1024];//arreglo de bites

        oos.writeObject(obj);//Escribimos el objeto dentro oos
        oos.flush();

        buf = baos.toByteArray();//Pasamos el bytearray a un arreglo de bites
        dp.setData(buf);
        
        s.send(dp);//Enviamos el arreglo de bytes
    }

    public static void main(String[] args) {
        int puerto = 8000;
        //DatagramPacket dp = null;
        

        ObjectInputStream ois = null;
        //Celular c2 = null;

        /*-----DECLARAMOS TODOS LOS PRODUCTOS-----*/
        productos.add(new Producto(1, "Redmi Airdots", 487.50, "Adifonos Bluetooth inalambricos Xiaomi", "redmi"));
        productos.add(new Producto(1, "Airpods", 3449.20, "Adifonos inalambricos Apple", "airpods"));
        productos.add(new Producto(1, "Sony MDR-EX15LPB", 139.90, "Adifonos Sony color negro", "mdr"));
        productos.add(new Producto(1, "JBL Endurance Run", 360.00, "Adifono JBL Endurance para deportes", "jbl"));
        productos.add(new Producto(1, "Sony Extra Bass", 759.90, "Adifonos Extra bass in eart", "extra"));
        productos.add(new Producto(1, "Bose SoundSport", 4699.90, "Adifonos Bose para deporte", "bose"));
        productos.add(new Producto(1, "Samsung Galaxy Buds", 2149.00, "Adifonos Galaxy Buds", "samsung"));
        productos.add(new Producto(1, "JBL T120TWS", 2299.03, "Adifonos JBL Azules", "jblt"));
        productos.add(new Producto(1, "AKG K92", 1029.00, "Adifonos AKG color negro", "akg"));
        productos.add(new Producto(1, "MacBook Air 13", 22990.09, "Laptop Macbook Air 13", "macbook"));
        productos.add(new Producto(1, "Hp Envy 360", 19999.00, "Laptop Hp envy 13'' ", "hp"));
        productos.add(new Producto(1, "Lenovo ThinkPad", 26999.12, "Laptop Lenovo Thinkpad", "lenovo"));
        productos.add(new Producto(1, "Dell Inspiron 2 en 1", 21898.42, "Laptop Dell 2 en 1 ", "dell"));

        try {
            s = new DatagramSocket(puerto);
            System.out.println("Servidor UDP iniciado en el puerto " + s.getLocalPort());
            System.out.println("Recibiendo datos...");
            for (int i = 0; i < 10; i++) {

                dp = new DatagramPacket(new byte[65000], 65000);
                s.receive(dp);

                System.out.println("Datagrama recibido... extrayendo informacion");
                /*
                System.out.println("Host remoto:" + dp.getAddress().getHostAddress() + ":" + dp.getPort());
                System.out.println("Datos del paquete:");

                ois = new ObjectInputStream(new ByteArrayInputStream(dp.getData()));
                c2 = (Celular) ois.readObject();
                
                System.out.println("El precio del celular = "+c2.getPrecio());
                 */
                String nombre = new String(dp.getData(), 0, dp.getLength());
                System.out.println("Comando = " + nombre);

                if ("1".equals(nombre)) {
                    System.out.println("Entramos");
                    enviarObjeto(productos.get(0));
                }
                //ois.close();
            }//for
            //s.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Termina el contenido del datagrama...");
    }//main
}//class
