## Quiz-Sistemas-Distribuidos
Este é um aplicativo Java simples que implementa um Servidor de Jogo de Quiz utilizando programação de Socket. Jogadores podem se conectar a este servidor usando um aplicativo cliente para participar de um jogo de quiz.

**Grupo:**
Gabriel Claudino
Gabriel Dunkel
Giulia Franca

#Como Funciona
O servidor cria uma nova thread para cada conexão de cliente. Cada thread lida com a comunicação entre o servidor e um cliente específico. O servidor envia perguntas do quiz para o cliente, recebe suas respostas e calcula a pontuação. Após o término do quiz, o servidor envia a pontuação final para o cliente e fecha a conexão.

#Programação de Socket
A programação de Socket é uma forma de conectar dois nós em uma rede para se comunicarem entre si. Neste aplicativo, a API de Socket do Java é utilizada para criar um servidor que escuta conexões entrantes de clientes. Para cada conexão, uma thread separada é criada para lidar com a comunicação com esse cliente. Isso permite que o servidor lide com múltiplos clientes simultaneamente.

#Visão Geral do Código
A classe ServidorThread implementa a interface Runnable, permitindo que ela seja executada por uma thread separada. O método run contém a lógica para se comunicar com o cliente. Ele envia perguntas do quiz para o cliente, recebe suas respostas e calcula a pontuação. Enquanto a classe Servidor implementa e cria o servidor, funcionando como Main. A classe cliente simplesmente se conecta ao servidor após ele ser criado.
