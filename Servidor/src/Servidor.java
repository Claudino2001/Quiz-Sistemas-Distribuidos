import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        int porta = 5001;
        System.out.println("* Servidor Executado. *");
        
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Porta " + porta + " iniciada. Aguardando requisição...");
        while (true) {
            try {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado: " + clienteSocket.getInetAddress().getHostAddress());
                Thread thread = new Thread(new ServidorThread(clienteSocket));
                thread.start();
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        //serverSocket.close();
        //System.out.println("\n* Servidor Finalizado. *");
    }
}
