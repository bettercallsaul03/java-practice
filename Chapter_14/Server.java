
//Угнивенко Дмитрий Б763-2
// Создать на основе сокетов клиент/серверное приложение.Вариант A. 5. Сервер рассылает сообщения в определенное время определенным клиентам

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }

    public void startServer() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9090);
            System.out.println("Server started on port 9090.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void broadcastMessage(String message) {
        for (PrintWriter client : clients) {
            client.println(message);
            client.flush();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(out);

                while (true) {
                    broadcastMessage("смартфон Vivo со скидкой");
                    Thread.sleep(10000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                clients.remove(out);
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
