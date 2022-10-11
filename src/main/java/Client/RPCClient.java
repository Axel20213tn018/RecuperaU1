package Client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner input = new Scanner(System.in);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        int opc;
        boolean confirm = false;
        Object[] param = new Object[4];
        Object[] a = new Object[2];
        a[0] = " ";
        a[1] = " ";

        do {
            System.out.println("Elige");
            System.out.println("1.- Registrar Vehiculo");
            System.out.println("2.- Ver Registros");
            opc = input.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Escribe el modelo: ");
                    param[0] = input.next();
                    System.out.println("Escribe la marca: ");
                    param[1] = input.next();
                    System.out.println("Escribe el color: ");
                    param[2] = input.next();
                    System.out.println("Escribe el Numero de Serie: ");
                    param[3] = input.next();

                    System.out.println("Esperando respuesta del servidor...");
                    String response = (String) client.execute("Methods.registrarAuto", param);

                    System.out.println(response);
                    break;
                case 2:
                    System.out.println("Esperando respuesta del servidor...");
                    String response2 = (String) client.execute("Methods.listadoAutos", a);
                    System.out.println(response2);
                    break;
                case 3:
                    System.out.println("Adios...");
                    break;
                default:
                    System.out.println("Error, opcion no valida");
                    break;
            }
        }while(opc != 3);
    }
}
