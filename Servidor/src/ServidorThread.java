import java.io.*;
import java.net.Socket;

public class ServidorThread implements Runnable {
    private Socket clienteSocket;
    private int placar = 0;  // Placar do jogador

    public ServidorThread(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);

            PerguntasQuiz quiz = new PerguntasQuiz();

            out.println("Bem-vindo ao Quiz Game!\nInsira seu nome de jogador: ");
            String nomeJogador = in.readLine();

            // Faça um loop para enviar perguntas e receber respostas
            for (int i = 0; i < quiz.getPerguntas().length; i++) {
                // Obtenha a pergunta, opções e resposta correta
                String[] pergunta = quiz.getPerguntas()[i];

                // Envie a pergunta e opções para o cliente
                out.println(pergunta[0]);
                out.println(pergunta[1]);
                out.println(pergunta[2]);
                out.println(pergunta[3]);
                out.println(pergunta[4]);
                out.println("Digite a resposta (A, B, C ou D):");

                // Receba a resposta do cliente
                String respostaCliente = in.readLine().toUpperCase();

                // Verifique se a resposta está correta
                if (respostaCliente.equals(pergunta[5])) {
                    placar++;
                    out.println("Resposta correta " + nomeJogador + "! Seu placar: " + placar);
                } else {
                    out.println("Resposta errada " + nomeJogador + "! Sua pontuação atual: " + placar);
                }
                out.println("");
            }

            // Exiba o placar final do jogador
            out.println("Fim do jogo! Jogador: " + nomeJogador + " | Placar final: " + placar);

            // Feche os fluxos e o socket
            in.close();
            out.close();
            clienteSocket.close();

        } catch (IOException e) {
            System.out.println("Erro na thread: " + e.getMessage());
        }
    }
}