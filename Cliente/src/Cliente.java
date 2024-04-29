import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PORTA = 5001;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORTA);
            System.out.println("Conectado ao servidor no host " + HOST + " na porta " + PORTA);

            // Crie um leitor para ler dados recebidos do servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Crie um escritor para enviar dados ao servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Crie um leitor para ler dados do console (para receber as respostas do cliente)
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            // Leia as mensagens recebidas do servidor
            String mensagem;
            while ((mensagem = in.readLine()) != null) {
                // Exiba a mensagem do servidor no console
                System.out.println(mensagem);

                // Verifique se a mensagem pede uma entrada do cliente
                if (mensagem.contains("Digite a resposta") || mensagem.contains("Insira seu nome de jogador")) {
                    // Leia a resposta do cliente a partir do console
                    String respostaCliente = consoleReader.readLine();

                    // Envie a resposta ao servidor
                    out.println(respostaCliente);
                }
            }

            // Feche os fluxos e o socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
