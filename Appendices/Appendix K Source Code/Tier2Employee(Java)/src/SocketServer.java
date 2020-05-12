import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        final int PORT = 6789;      //Tier2 server port
        System.out.println("Starting server...\n\n\n\n");

        Request test = new Request("GET", "employee", "JusJan,2062F80093066633876B542212C496501A5E79523CC4EA9B28667DFF065AFD8F");
        System.out.println(test.CallTier3());

        try {
            ServerSocket welcomeSocket = new ServerSocket(PORT);
            while(true)
            {
                System.out.println("Waiting for a client...");

                Socket socket = welcomeSocket.accept();

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
