import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        String msg = "";
        while(!msg.equals("0")){
            Socket cliente = server.accept();
            System.out.print("Mensagem do IP "+cliente.getInetAddress()+": ");
            Scanner entrada = new Scanner(cliente.getInputStream());
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
                cliente = server.accept();
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                Scanner inp = new Scanner(System.in);
                String mensagem = inp.next();
                saida.writeChars(mensagem);
                saida.close();
            }
            entrada.close();
        }

        server.close();

    }
}
