
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String serverHost = "localhost";
        final int serverPort = 9090;

        try {
            Socket socket = new Socket(serverHost, serverPort);
            System.out.println("Сервер подключен к: " + serverHost + ":" + serverPort);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Получено сообщение: " + message);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
