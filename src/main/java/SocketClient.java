import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while(true){
            Socket cliente = new Socket("127.0.0.1", 12345);
            Scanner scanner = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            String entrada = scanner.nextLine();
            saida.println(entrada);
            saida.close();
            cliente.close();
            cliente = new Socket("localhost", 12345);
            ObjectInputStream msg = new ObjectInputStream(cliente.getInputStream());
            String retorno = msg.readLine();
            System.out.println("Mensagem do Servidor: "+retorno);
            msg.close();
            cliente.close();
        }
    }
}
